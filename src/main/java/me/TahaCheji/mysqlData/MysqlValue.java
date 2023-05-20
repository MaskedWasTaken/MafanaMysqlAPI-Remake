package me.TahaCheji.mysqlData;

import java.util.UUID;

public class MysqlValue {
    public final String name;
    private UUID mysqlUUID;

    private Integer intValue = null;
    private String stringValue = null;
    private Double doubleValue = null;
    public UUID uuidValue = null;
    private Object objectValue = null;

    public MysqlValue(String name) {
        this.name = name;
    }

    public MysqlValue(String name,UUID mysqlUUID, Integer intValue) {
        this.name = name;
        this.mysqlUUID = mysqlUUID;
        this.intValue = intValue;
    }

    public MysqlValue(String name, UUID mysqlUUID, String stringValue) {
        this.name = name;
        this.mysqlUUID = mysqlUUID;
        this.stringValue = stringValue;
    }

    public MysqlValue(String name, UUID mysqlUUID, Double doubleValue) {
        this.name = name;
        this.mysqlUUID = mysqlUUID;
        this.doubleValue = doubleValue;
    }

    public MysqlValue(String name, UUID mysqlUUID, Object objectValue) {
        this.name = name;
        this.mysqlUUID = mysqlUUID;
        this.objectValue = objectValue;
    }

    public MysqlValue(String name, UUID mysqlUUID, UUID uuidValue) {
        this.name = name;
        this.mysqlUUID = mysqlUUID;
        this.uuidValue = uuidValue;
    }

    public MysqlValue(String name, Integer intValue) {
        this.name = name;
        this.intValue = intValue;
    }

    public MysqlValue(String name, String stringValue) {
        this.name = name;
        this.stringValue = stringValue;
    }

    public MysqlValue(String name, Double doubleValue) {
        this.name = name;
        this.doubleValue = doubleValue;
    }

    public MysqlValue(String name,Object objectValue) {
        this.name = name;
        this.objectValue = objectValue;
    }

    public MysqlValue(String name, UUID uuidValue) {
        this.name = name;
        this.uuidValue = uuidValue;
    }

    public UUID getUuidValue() {
        return uuidValue;
    }

    public void setUuidValue(UUID uuidValue) {
        this.uuidValue = uuidValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public void setObjectValue(Object objectValue) {
        this.objectValue = objectValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getName() {
        return name;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public UUID getMysqlUUID() {
        return mysqlUUID;
    }

    public Object getObjectValue() {
        return objectValue;
    }

    public String getStringValue() {
        return stringValue;
    }


}

