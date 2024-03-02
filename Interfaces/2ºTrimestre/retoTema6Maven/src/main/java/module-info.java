module retoTema6Maven {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;
	requires java.persistence;
	requires org.hibernate.orm.core;

	opens reto to javafx.graphics, javafx.fxml;

}
