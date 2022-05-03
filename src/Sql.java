import java.io.*;

public class Sql {
    private BufferedReader in;
    private BufferedWriter out;
    private StringBuffer buffer;
    private String[][] data;

    public boolean insert(String[] data, String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            this.out = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < data.length; i++) {
                this.out.write(data[i] + ",");
            }
            this.out.write("\n");
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return false;
        } finally {
            try {
                if (this.out != null) {
                    this.out.close();
                    file = null;
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
        return true;
    }

    public String[][] select(String path) {
        String text = "";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            this.in = new BufferedReader(new FileReader(file));
            this.data = new String[this.line(file)][this.column(file)];
            for (int i = 0; i < this.data.length; i++) {
                text = this.in.readLine();
                for (int j = 0; j < this.data[i].length; j++) {
                    this.data[i][j] = text.split(",")[j];
                }
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        } finally {
            try {
                if (this.in != null) {
                    this.in.close();
                    file = null;
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
        return this.data;
    }

    public int line(File file) {
        int line = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            while (in.readLine() != null) {
                line++;
            }
            in.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return line;
    }

    public int column(File file) {
        int column = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            column = in.readLine().split(",").length;
            in.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return column;
    }

    public boolean delete(String[] data, String path) {
        /// ลบสินค้า
        File file = new File(path);
        this.data = this.select(path);
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i][0].equals(data[0])) {
                for (int j = 0; j < this.data[i].length; j++) {
                    this.data[i][j] = "";
                }
            }
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            this.out = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < this.data.length; i++) {
                if (this.data[i][0] != "") {
                    for (int j = 0; j < this.data[i].length; j++) {
                        this.out.write(this.data[i][j] + ",");
                    }
                    this.out.write("\n");
                }
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return false;
        } finally {
            try {
                if (this.out != null) {
                    this.out.close();
                    file = null;
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }
        return true;
    }

    public boolean update(String[] data, String path) {
        File file = new File(path);
        this.data = this.select(path);
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i][0].equals(data[0])) {
                for (int j = 0; j < this.data[i].length; j++) {
                    this.data[i][j] = data[j];
                }
            }
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            this.out = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < this.data.length; i++) {
                for (int j = 0; j < this.data[i].length; j++) {
                    this.out.write(this.data[i][j] + ",");
                }
                this.out.write("\n");
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return false;
        } finally {
            try {
                if (this.out != null) {
                    this.out.close();
                    file = null;
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }

        return true;
    }

}