public class Antrean extends DataDiri{
    protected Antrean selanjutnya;
    private int nomorUrut;
    private static int panjangAntrean = 0;
    private String nama;
    private String alamat;
    private String jenisKelamin;

    Antrean(String nama, String alamat, String jenisKelamin, int nomorUrut) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.nomorUrut = nomorUrut;
        this.selanjutnya = null;
    }
    // overload method, berguna nanti ketika intansiasi objek antrian, objek pertama akan tiap attributnya akan bernilai null
    Antrean() {}

    public Antrean tambah(Antrean selanjutnya) {
        Antrean temp = this;
        // jika data antrian pertama kososng
        if (temp.nama == null && temp.alamat == null && temp.jenisKelamin == null && temp.nomorUrut == 0) {
            System.out.println("antrian baru");
            panjangAntrean += 1;
            return selanjutnya;
        }

        while (temp.selanjutnya != null) {
            temp = temp.selanjutnya;
        }
        temp.selanjutnya = selanjutnya;
        panjangAntrean += 1;
        return this;
    }

    public Antrean kurangi() {
        if (this.selanjutnya == null) {
            panjangAntrean = 0;
            return new Antrean();
        }
        panjangAntrean -= 1;
        return this.selanjutnya;// mengganti nilai objek antrian saat ini dengan objek antrian sebelumnya
    }

    protected void setNama(String nama){
        this.nama = nama;
    }
    protected void setAlamat(String alamat){
        this.alamat = alamat;
    }
    protected void setJenisKelamin(String jenisKelamin){
        this.jenisKelamin = jenisKelamin;
    }
    protected void setNomorUrut(int nomorUrut){
        this.nomorUrut = nomorUrut;
    }
    protected String getNama(){
        return this.nama;
    }
    protected String getAlamat(){
        return this.alamat;
    }
    protected String getJenisKelamin(){
        return this.jenisKelamin;
    }
    protected int getNomorUrut(){
        return this.nomorUrut;
    }
    protected Antrean getSpecificData(int nomorUrut){
        Antrean temp = this;
        while(temp.nomorUrut != 0){
            if (temp.nomorUrut == nomorUrut) {
                return temp;
            }
            temp = temp.selanjutnya;
        }
        return null;
    }
    public static int getPanjangAntrean() {
        return panjangAntrean;
    }

    

    @Override
    public String[] getDataDiri() {
        // return data dari antrian terluar
        String data[] = {this.nama, this.alamat, this.jenisKelamin, String.valueOf(this.nomorUrut)};
        return data;
    }
}
