package application;

public class operation {
   private int ido;

   private String nameo;
   private String lnameo;
   private String typeo;
   private String dateo;
   private Float amounto;
public operation(int ido,  String nameo, String lnameo, String typeo, String dateo, Float amounto) {
	super();
	this.ido = ido;
	
	this.nameo = nameo;
	this.lnameo = lnameo;
	this.typeo = typeo;
	this.dateo = dateo;
	this.amounto = amounto;
}

public String getNameo() {
	return nameo;
}
public void setNameo(String nameo) {
	this.nameo = nameo;
}
public String getLnameo() {
	return lnameo;
}
public void setLnameo(String lnameo) {
	this.lnameo = lnameo;
}
public String getTypeo() {
	return typeo;
}
public void setTypeo(String typeo) {
	this.typeo = typeo;
}
public String getDateo() {
	return dateo;
}
public void setDateo(String dateo) {
	this.dateo = dateo;
}
public Float getAmounto() {
	return amounto;
}
public void setAmounto(Float amounto) {
	this.amounto = amounto;
}
public int getIdo() {
	return ido;
}

   
}
