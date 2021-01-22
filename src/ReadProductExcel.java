import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import user.User;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class ReadProductExcel {
    /**
     * 返回所有的商品
     * @param in
     * @return 包含了所有商品的数组
     */
    public Product[] getAllProduct(InputStream in) {
        Product products[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            products = new Product[xs.getLastRowNum()];
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                Product product = new Product();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {

                        product.setId(this.getValue(cell));
                    } else if (k == 1) {

                        product.setName(this.getValue(cell));
                    } else if (k == 2) {

                        product.setPrice(Float.valueOf(this.getValue(cell)));
                    } else if (k == 3) {

                        product.setDesc(this.getValue(cell));
                    }
                }
                products[j - 1] = product;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    /**
     * 根据ID查找商品
     * @param id
     * @param in
     * @return 返回id对应的商品
     */

    public Product getProductById(String id, InputStream in) {
        try {
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            for (int j = 1; j <= xs.getLastRowNum(); j++) {
                XSSFRow row = xs.getRow(j);
                Product product = new Product();//每循环一次就把电子表格的一行的数据给对象赋值
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {

                        product.setId(this.getValue(cell));
                    } else if (k == 1) {

                        product.setName(this.getValue(cell));
                    } else if (k == 2) {

                        product.setPrice(Float.valueOf(this.getValue(cell)));
                    } else if (k == 3) {

                        product.setDesc(this.getValue(cell));
                    }
                }
                if (id.equals(product.getId())) {
                    return product;
                }//如果id(手动输入的）和product的id（从电子表格立读出来的）一致，则表示找到了该商品，然后返回该商品即可
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellTypeEnum();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case NUMERIC:
                DecimalFormat df = new DecimalFormat("#");
                value = df.format(cell.getNumericCellValue());

                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "非法字符";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}