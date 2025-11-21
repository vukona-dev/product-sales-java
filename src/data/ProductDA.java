package data;

/**
 *
 * @author Vukona-Maritz
 */
import java.sql.*;
import java.util.ArrayList;
import model.*;
import exceptions.*;

public class ProductDA {

    public static Connection getProductSalesDbConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/productsaledb";
        String user = "root";
        String password = ""; // Update if your MySQL has a password
        return DriverManager.getConnection(url, user, password);
    }

    public static void addProduct(Product objProduct) throws SQLException {
        try (Connection conn = getProductSalesDbConnection()) {
            String sql = "INSERT INTO tblproduct VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, objProduct.getBarcodeNo());
            ps.setString(2, objProduct.getProductName());
            ps.setString(3, objProduct.getProductCategory());
            ps.setString(4, objProduct.getManufacturer());
            if (objProduct instanceof WeightBasedProduct) {
                ps.setInt(5, ((WeightBasedProduct) objProduct).getWeight());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            ps.setInt(6, objProduct.getUnitPrice());
            ps.setDouble(7, objProduct.getAmountPaid());
            ps.executeUpdate();
        }
    }

    public static ArrayList<Product> returnAll() throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        try (Connection conn = getProductSalesDbConnection()) {
            String sql = "SELECT * FROM tblproduct";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String category = rs.getString("Product_Category");
                if ("IBP".equalsIgnoreCase(category)) {
                    list.add(new ItemBasedProduct(
                        rs.getInt("Barcode_No"),
                        rs.getString("Product_Name"),
                        category,
                        rs.getString("Manufacturer"),
                        rs.getInt("Unit_Price"),
                        rs.getDouble("Amount_Paid")
                    ));
                } else {
                    list.add(new WeightBasedProduct(
                        rs.getInt("Barcode_No"),
                        rs.getString("Product_Name"),
                        category,
                        rs.getString("Manufacturer"),
                        rs.getInt("Weight"),
                        rs.getInt("Unit_Price"),
                        rs.getDouble("Amount_Paid")
                    ));
                }
            }
        }
        return list;
    }

    public static double calculateTotalWBP() throws SQLException {
        double total = 0;
        try (Connection conn = getProductSalesDbConnection()) {
            String sql = "SELECT SUM(Amount_Paid) FROM tblproduct WHERE Product_Category = 'WBP'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) total = rs.getDouble(1);
        }
        return total;
    }

    public static double calculateTotalIBP() throws SQLException {
        double total = 0;
        try (Connection conn = getProductSalesDbConnection()) {
            String sql = "SELECT SUM(Amount_Paid) FROM tblproduct WHERE Product_Category = 'IBP'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) total = rs.getDouble(1);
        }
        return total;
    }

    public static void updatePrice(int barcode, int percentage) throws SQLException {
        try (Connection conn = getProductSalesDbConnection()) {
            String sql = "UPDATE tblproduct SET Unit_Price = Unit_Price + (Unit_Price * ? / 100) WHERE Barcode_No = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, percentage);
            ps.setInt(2, barcode);
            ps.executeUpdate();
        }
    }

    public static ArrayList<Integer> returnBarcodes() throws SQLException {
        ArrayList<Integer> barcodes = new ArrayList<>();
        try (Connection conn = getProductSalesDbConnection()) {
            String sql = "SELECT Barcode_No FROM tblproduct";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                barcodes.add(rs.getInt("Barcode_No"));
            }
        }
        return barcodes;
    }
}
