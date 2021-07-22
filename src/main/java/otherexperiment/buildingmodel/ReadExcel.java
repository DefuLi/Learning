package otherexperiment.buildingmodel;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack Lee
 * @date 2020/9/17 23:17
 */
public class ReadExcel {
    public static void main(String[] args) throws IOException {
        ReadExcel readExcel = new ReadExcel();
        List<List<Object>> excelContent = ExcelUtils.readExcelFirstSheet("src/main/java/otherexperiment/buildingmodel/附件四：354个操作变量信息(删零).xlsx");
        List<Object> range = readExcel.getRange(excelContent);
        List<List<Object>> minMax = readExcel.getMinMax(range);
        List<String> title = new ArrayList<>();
        title.add("最小值");
        title.add("最大值");
        Workbook workbook = ExcelUtils.getWorkbookFromExcel(new File("src/main/java/otherexperiment/buildingmodel/最小最大值范围.xlsx"));
        ExcelUtils.writeDataToWorkbook(title, minMax, workbook, 0);
        ExcelUtils.writeWorkbookToFile(workbook, new File("src/main/java/otherexperiment/buildingmodel/最小最大值范围.xlsx"));

    }

    public List<Object> getRange(List<List<Object>> excelContent) {
        List<Object> range = new ArrayList<>();
        for (int i = 1; i < excelContent.size(); i++) {
            range.add(excelContent.get(i).get(3));
        }
        return range;
    }

    public List<List<Object>> getMinMax(List<Object> range) {
        List<List<Object>> res = new ArrayList<>();
        for (Object item : range) {
            String s = (String) item;
            List<Object> temp = new ArrayList<>();
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean flag = false;  // 默认为flase 碰到第一个'-' 改为true
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == '-' && i != 0 && !flag) {
                    flag = true;
                    temp.add(sb.toString());
                    sb.delete(0, sb.length());
                    continue;
                }
                if(chars[i] != '(' && chars[i] != '（' && chars[i] != ')' && chars[i] != '）') {
                    sb.append(chars[i]);
                }
            }
            temp.add(sb.toString());
            res.add(temp);
        }
        return res;
    }

}
