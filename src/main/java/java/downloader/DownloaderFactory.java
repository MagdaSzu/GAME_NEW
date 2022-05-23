package java.downloader;

public class DownloaderFactory {

    public static Downloader buildDownloader(String typ) {
        if (typ.equals("txt")) {
            return new WordsDownloaderTxt();
        } else {
            return null;
        }
    }
}
