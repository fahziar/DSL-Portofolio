/**
 * Created by fahziar on 30/11/2015.
 */

class Util {
    public static void copyFolder(File src, File dest) throws IOException{
        if(src.isDirectory()){

            if(!dest.exists()){
                dest.mkdir();
            }

            String[] files = src.list();

            for (String file : files) {
                File srcFile = new File(src, file);

                File destFile = new File(dest, file);
                copyFolder(srcFile,destFile);
            }

        }else{
            InputStream inputStream = new FileInputStream(src);
            OutputStream outputStream = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();
        }
    }
}
