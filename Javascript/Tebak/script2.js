
function Angkot(supir, trayek, penumpang, kas){

    this.supir = supir;
    this.trayek = trayek;
    this.penumpang = penumpang;
    this.kas = kas;

    this.naik = function(namaPenumpang){
        this.penumpang.push(namaPenumpang);
        return this.penumpang;
    }

    this.turun = function(bayar){
        this.penumpang.pop();
        this.kas = this.kas + bayar;
        return this.kas;
    }
}

var angkot1 = new Angkot("Ucup", "Cicaheum - Cibiru", [], 0);

