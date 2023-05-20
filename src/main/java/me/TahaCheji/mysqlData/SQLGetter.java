package me.TahaCheji.mysqlData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SQLGetter {

    public MySQL mySQL;
    public String tableString;
    public List<MysqlValue> mysqlValues = new ArrayList<>();

    public SQLGetter(MySQL plugin) {
        this.mySQL = plugin;
    }

    public void createTable(String tableName, MysqlValue... mysqlValues) {
        tableString = tableName;
        PreparedStatement ps;
        try {
            String x3 = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
            for (MysqlValue mysqlValue : mysqlValues) {
                if (mysqlValues.length != 1) {
                    if (mysqlValue.getStringValue() != null) {
                        x3 = x3 + mysqlValue.getName() + " VARCHAR(100),";
                        continue;
                    }
                    if (mysqlValue.getIntValue() != null) {
                        x3 = x3 + mysqlValue.getName() + " INT(100),";
                        continue;
                    }
                    if (mysqlValue.getDoubleValue() != null) {
                        x3 = x3 + mysqlValue.getName() + " DOUBLE(5,0),";
                        continue;
                    }
                    if (mysqlValue.getUuidValue() != null) {
                        x3 = x3 + mysqlValue.getName() + " VARCHAR(100),";
                    }
                    getMysqlValues().add(mysqlValue);
                } else {
                    if (mysqlValue.getStringValue() != null) {
                        x3 = x3 + mysqlValue.getName() + " VARCHAR(100)";
                        continue;
                    }
                    if (mysqlValue.getIntValue() != null) {
                        x3 = x3 + mysqlValue.getName() + " INT(100)";
                        continue;
                    }
                    if (mysqlValue.getDoubleValue() != null) {
                        x3 = x3 + mysqlValue.getName() + " DOUBLE(5,0)";
                        continue;
                    }
                    if (mysqlValue.getUuidValue() != null) {
                        x3 = x3 + mysqlValue.getName() + " VARCHAR(100)";
                    }
                    getMysqlValues().add(mysqlValue);
                }
            }
            if (mysqlValues.length != 1) {
                x3 = x3 + "UUID VARCHAR(100)";
            }
            x3 = x3 + ")";
            System.out.println(x3);
            ps = mySQL.getConnection().prepareStatement(x3);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(UUID uuid) {
        try {
            PreparedStatement ps = getMySQL().getConnection().prepareStatement("SELECT * FROM " + tableString + " WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void setInt(MysqlValue mysqlValue) {
        try {
            if(!exists(mysqlValue.getMysqlUUID())) {
                PreparedStatement ps2 = getMySQL().getConnection().prepareStatement("INSERT IGNORE INTO " + tableString + " (" + mysqlValue.getName() + ",UUID) VALUES (?,?)");
                ps2.setInt(1, mysqlValue.getIntValue());
                ps2.setString(2, mysqlValue.getMysqlUUID().toString());
                ps2.executeUpdate();
            } else {
                PreparedStatement ps = getMySQL().getConnection().prepareStatement("UPDATE " + tableString + " SET " + mysqlValue.getName() + "=? " + "WHERE UUID=?");
                ps.setInt(1, mysqlValue.getIntValue());
                ps.setString(2, mysqlValue.getMysqlUUID().toString());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getInt(UUID uuid, MysqlValue mysqlValue) {
        try {
            PreparedStatement ps = getMySQL().getConnection().prepareStatement("SELECT " + mysqlValue.getName() + " FROM "  + tableString + " WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            int xp = 0;
            if(rs.next()) {
                xp = rs.getInt(mysqlValue.getName());
                return xp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setString(MysqlValue mysqlValue) {
        try {
            if(!exists(mysqlValue.getMysqlUUID())) {
                PreparedStatement ps2 = getMySQL().getConnection().prepareStatement("INSERT IGNORE INTO " + tableString + " (" + mysqlValue.getName() + ",UUID) VALUES (?,?)");
                ps2.setString(1, mysqlValue.getStringValue());
                ps2.setString(2, mysqlValue.getMysqlUUID().toString());
                ps2.executeUpdate();
            } else {
                PreparedStatement ps = getMySQL().getConnection().prepareStatement("UPDATE " + tableString + " SET " + mysqlValue.getName() + "=? " + "WHERE UUID=?");
                ps.setString(1, mysqlValue.getStringValue());
                ps.setString(2, mysqlValue.getMysqlUUID().toString());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getString(UUID uuid, MysqlValue mysqlValue) {
        try {
            PreparedStatement ps = getMySQL().getConnection().prepareStatement("SELECT " + mysqlValue.getName() + " FROM "  + tableString + " WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            String xp;
            if(rs.next()) {
                xp = rs.getString(mysqlValue.getName());
                return xp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setDouble(MysqlValue mysqlValue) {
        try {
            if(!exists(mysqlValue.getMysqlUUID())) {
                PreparedStatement ps2 = getMySQL().getConnection().prepareStatement("INSERT IGNORE INTO " + tableString + " (" + mysqlValue.getName() + ",UUID) VALUES (?,?)");
                ps2.setDouble(1, mysqlValue.getDoubleValue());
                ps2.setString(2, mysqlValue.getMysqlUUID().toString());
                ps2.executeUpdate();
            } else {
                PreparedStatement ps = getMySQL().getConnection().prepareStatement("UPDATE " + tableString + " SET " + mysqlValue.getName() + "=? " + "WHERE UUID=?");
                ps.setDouble(1, mysqlValue.getDoubleValue());
                ps.setString(2, mysqlValue.getMysqlUUID().toString());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Double getDouble(UUID uuid, MysqlValue mysqlValue) {
        double xp = 0;
        try {
            PreparedStatement ps = getMySQL().getConnection().prepareStatement("SELECT " + mysqlValue.getName() + " FROM " + tableString + " WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            xp = 0.0;
            if (rs.next()) {
                xp = rs.getDouble(mysqlValue.getName());
                return xp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xp;
    }

    public void setUUID(MysqlValue mysqlValue) {
        try {
            if(!exists(mysqlValue.getMysqlUUID())) {
                PreparedStatement ps2 = getMySQL().getConnection().prepareStatement("INSERT IGNORE INTO " + tableString + " (" + mysqlValue.getName() + ",UUID) VALUES (?,?)");
                ps2.setString(1, mysqlValue.getUuidValue().toString());
                ps2.setString(2, mysqlValue.getMysqlUUID().toString());
                ps2.executeUpdate();
            } else {
                PreparedStatement ps = getMySQL().getConnection().prepareStatement("UPDATE " + tableString + " SET " + mysqlValue.getName() + "=? " + "WHERE UUID=?");
                ps.setString(1, mysqlValue.getUuidValue().toString());
                ps.setString(2, mysqlValue.getMysqlUUID().toString());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public UUID getUUID(UUID uuid, MysqlValue mysqlValue) {
        UUID xp = null;
        try {
            PreparedStatement ps = getMySQL().getConnection().prepareStatement("SELECT " + mysqlValue.getName() + " FROM " + tableString + " WHERE UUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                xp = UUID.fromString(rs.getString(mysqlValue.getName()));
                return xp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xp;
    }


    public MySQL getMySQL() {
        return mySQL;
    }

    public List<MysqlValue> getMysqlValues() {
        return mysqlValues;
    }
}
