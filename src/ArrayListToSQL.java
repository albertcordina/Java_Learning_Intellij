import java.sql.*;
import java.util.ArrayList;

public class ArrayListToSQL {

    public static void main(String[] args) {

        // Step 2: Establish JDBC connection:
        String url = "jdbc:mysql://localhost:3306/mydb"; // for mysql.
        String username = "albertcordina";

        //  String url = "jdbc:postgresql://localhost:5432/albertcordina"; // for postgresql.
        //  String username = "postgres";

        String password = "Forecastoflove1516";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            // Step 4: Populate ArrayList with data:
            ArrayList<MyDataModel> dataList = new ArrayList<>();
            dataList.add(new MyDataModel("Bill", 35));
            dataList.add(new MyDataModel("Victoria", 28));

            // Step 5: Insert data into SQL/Postgresql table:
            for (MyDataModel data : dataList) {
                String insertQuery = "INSERT INTO ArrayListToSQL (name, age) VALUES (?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, data.getName());
                    preparedStatement.setInt(2, data.getAge());
                    preparedStatement.executeUpdate();
                }
            }

            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Step 3: Create a Data Model
class MyDataModel {
    private String name;
    private int age;

    public MyDataModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
