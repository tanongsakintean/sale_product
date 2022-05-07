public class Mange_m extends Sql {

    public boolean AddMember(String mem[], int status) {
        if (status == 1) {
            String product[] = {
                    "" + (this.maxId(this.select("DB/Members/customer.txt")) + 1) + "," + mem[0] + "," + mem[1] + ","
                            + mem[2] + "," + mem[3] + "," + mem[4] };
            return this.insert(product, "DB/Members/customer.txt");
        } else {
            String product[] = {
                    "" + (this.maxId(this.select("DB/Members/saler.txt")) + 1) + "," + mem[0] + "," + mem[1] + ","
                            + mem[2] + "," + mem[3] + "," + mem[4] };
            return this.insert(product, "DB/Members/saler.txt");
        }
    }

    public String[][] GetMember(int status) {
        if (status == 1) {
            return this.select("DB/Members/customer.txt");
        } else {
            return this.select("DB/Members/saler.txt");
        }
    }

    public boolean EditMember(String mem[], int status) {
        if (status == 1) {
            return this.update(mem, "DB/Members/customer.txt");
        } else {
            return this.update(mem, "DB/Members/saler.txt");
        }
    }

    public boolean DeleteMember(String mem[], int status) {
        if (status == 1) {
            return this.delete(mem, "DB/Members/customer.txt");
        } else {
            return this.delete(mem, "DB/Members/saler.txt");
        }
    }

}