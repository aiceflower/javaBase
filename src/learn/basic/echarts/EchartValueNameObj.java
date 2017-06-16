package learn.basic.echarts;

import java.math.BigDecimal;
import java.util.List;

public class EchartValueNameObj {
    
    public EchartValueNameObj(Object value, String name) {
        this.value = value;
        this.name = name;
    }
    
    private String name;
    
    private Object value;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Object getValue() {
        return value;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        boolean flag = true;
        if (this.value instanceof Integer) {
            flag = ((Integer)this.value).intValue() == 0 ? false : true;
        }
        if (this.value instanceof BigDecimal) {
            flag = ((BigDecimal)this.value).compareTo(BigDecimal.ZERO) == 1 ? true : false;
        }
        String str = null;
        if (flag) {
            str = "{value:" + this.value + ", name:'" + this.name + "'}";
        }
        return str;
    }
    
    public static void main(String[] args) {
        BigDecimal memberFee = new BigDecimal(2);
        BigDecimal fee = new BigDecimal("102.32");
        List<EchartValueNameObj> nameObjs = new EchartList<EchartValueNameObj>();
        nameObjs.add(new EchartValueNameObj(memberFee, "VIP消费金额"));
        nameObjs.add(new EchartValueNameObj(fee, "普通消费金额"));
        System.out.println(nameObjs.toString());
    }
}
