package Utils;

import io.opentelemetry.api.internal.Utils;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;

public class ExcelDataProvidor {

    public class excelDataProvider {
        @DataProvider(name = "multiSheetExcelRead")
        public static Object[][] multiSheetExcelRead(Method method) throws Exception {
            File file = new File("./src/test/resources/Excel Files/TestData.xlsx");
            String SheetName = method.getName();
            return ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
        }

        @DataProvider(name = "excelSheetNameAsMethodName")
        public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception {
            File file = new File("src/test/resources/Test Data/Excel Files/" + method.getName() + ".xlsx");
            return ExcelUtils.getTableArray(file.getAbsolutePath());
        }
    }
}
