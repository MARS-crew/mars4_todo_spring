package mars4.todos.util;

import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.util.FileCopyUtils;

public class FileUploadUtil {

    /* 파일 업로드 처리 */
    public static String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath) throws Exception {
        UUID uid = UUID.randomUUID();

        String newFileName = uid + "_" + fileName;
        String imgPath = uploadPath + ymdPath;

        File target = new File(imgPath, newFileName);

        FileCopyUtils.copy(fileData, target);

        return newFileName;
    }

    /* 파일 업로드 처리 */
    public static String fileUploadToOriginName(String uploadPath, String fileName, byte[] fileData) throws Exception {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String randomNumber = getRandomNumber();
        String newFileName = randomNumber + "-" + date + "-" + fileName;

        File target = new File(uploadPath, newFileName);

        FileCopyUtils.copy(fileData, target);

        return newFileName;
    }

    /* 날짜 경로 생성 */
    public static String calcPath(String uploadPath) {
        Calendar cal = Calendar.getInstance();
        String yearPath = File.separator + cal.get(Calendar.YEAR);
        String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
        String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

        makeDir(uploadPath, yearPath, monthPath, datePath);

        return datePath;
    }

    /* 실제 폴더 생성 */
    private static void makeDir(String uploadPath, String... paths) {
        if (new File(paths[paths.length - 1]).exists()) {
            return;
        }

        for (String path : paths) {
            File dirPath = new File(uploadPath + path);

            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
        }
    }

    /* Random 숫자 생성 */
    public static String getRandomNumber() {
        int randomNumber =  ThreadLocalRandom.current().nextInt(100000, 1000000);
        return Integer.toString(randomNumber);
    }
}