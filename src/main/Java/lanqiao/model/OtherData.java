package lanqiao.model;

public class OtherData {
    private String dataId;

    private String dataName;

    private String dataValue;

    private String dataProductId;
    //参数数组
    private String [] values;

    public String []  getValues(){
        if(dataValue!=null){
          return    dataValue.split("\\s+");
        }
        return   null;
    }



    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId == null ? null : dataId.trim();
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue == null ? null : dataValue.trim();
    }

    public String getDataProductId() {
        return dataProductId;
    }

    public void setDataProductId(String dataProductId) {
        this.dataProductId = dataProductId == null ? null : dataProductId.trim();
    }
}