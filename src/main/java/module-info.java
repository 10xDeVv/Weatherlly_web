/**
 * Module descriptor.
 *
 * @author Besmir Beqiri
 */
module one.jpro.hellojpro {
    requires javafx.controls;
    requires javafx.fxml;
    requires jpro.webapi;
    requires javafx.graphics;
    requires java.net.http;
    requires static lombok;
    requires com.fasterxml.jackson.databind;

    exports one.jpro.hellojpro;
    opens one.jpro.hellojpro to javafx.fxml;
}