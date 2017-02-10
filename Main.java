package saccoSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import saccoSystem.MatatuTransaction.MatatuTransController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;

public class Main extends Application {
    public static Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

public static BorderPane layout ,layout1,layout2,layout3,layout9,layout10,layout6,layout8,layout11,layout13 ,v1;
    public static Stage primaryStage;
    public static SplitPane layout4,layout5;




    @Override
    public void start(Stage primaryStage) throws IOException{
        checkconnection();

        this.primaryStage=primaryStage;
        primaryStage.setTitle("matatu registration form ");
        MatatuTransController trans=new MatatuTransController();
        trans.fillcombo();

       ShowTellerpage();
      // showView();
     //   showMatRegistered();

    //  ownerForm();
       checkconnection();

       // ShowAdmin();
    // MatTrans();
      //  SaccoTrans();
       //OwnerTrans();
     // loginform();
       // signup();
     //   driverform();

    }


    public static  void showView() throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("mataturegistration/matatureg.fxml"));
        layout=loader.load();

        Scene scen=new Scene(layout);

        primaryStage.show();
        primaryStage.setScene(scen);



    }

    public static  void ownerForm() throws IOException {

        FXMLLoader lod= new FXMLLoader();
        lod.setLocation(Main.class.getResource("ownersregistration/owner reg.fxml"));
        layout1=lod.load();

        Scene scene=new Scene(layout1);

        primaryStage.show();
        primaryStage.setScene(scene);
    }
    public static void driverform() throws IOException {
     FXMLLoader loaad=new FXMLLoader();
     loaad.setLocation(Main.class.getResource("driverRegistration/Driver Reg.fxml"));
     layout2=loaad.load();

     Scene set=new Scene(layout2);

     primaryStage.setScene(set);
     primaryStage.show();
    }

        public static void ShowTellerpage() throws IOException{
        primaryStage.setTitle("Teller PAGE");
        FXMLLoader loadit=new FXMLLoader();
            loadit.setLocation(Main.class.getResource("homePage/TellerPage.fxml"));
            layout3=loadit.load();

            Scene setscene=new Scene(layout3);

            primaryStage.show();
            primaryStage.setScene(setscene);
            primaryStage.setResizable(false);
        }
    public static void ShowAdmin() throws IOException{
        primaryStage.setTitle("Admin PAGE");
        FXMLLoader loadit=new FXMLLoader();
        loadit.setLocation(Main.class.getResource("administratorPage/Admin.fxml"));
        layout3=loadit.load();

        Scene setscene=new Scene(layout3);

        primaryStage.show();
        primaryStage.setScene(setscene);
        primaryStage.setResizable(false);
    }

    public static void MatTrans() throws IOException {
        primaryStage.setTitle("Matatu transaction PAGE");
        FXMLLoader load1 = new FXMLLoader();
        load1.setLocation(Main.class.getResource("MatatuTransaction/MatatuTrans.fxml"));
        layout4 = load1.load();

        Scene scen1 = new Scene(layout4);

        primaryStage.show();
        primaryStage.setScene(scen1);
    }
    public static void OwnerTrans() throws IOException {
        primaryStage.setTitle("Owner transaction PAGE");
        FXMLLoader load2 = new FXMLLoader();
        load2.setLocation(Main.class.getResource("OwnerTransaction/ownerPay.fxml"));
        layout5 = load2.load();

        Scene scen2 = new Scene(layout5);

        primaryStage.show();
        primaryStage.setScene(scen2);
    }
    public static void SaccoTrans() throws IOException {
        primaryStage.setTitle("Sacco transaction PAGE");
        FXMLLoader load3 = new FXMLLoader();
        load3.setLocation(Main.class.getResource("SaccoTrans/SaccoTrans.fxml"));
        layout5= load3.load();

        Scene scen3 = new Scene(layout5);

        primaryStage.show();
        primaryStage.setScene(scen3);
    }
    public static  void display_dailyanalysis(){
       Stage window=new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("daily Analysis");
        Label label1=new Label("Please choose the analysis to view");
        label1.setAlignment(Pos.CENTER);

        Button buton1 = new Button("Daily Matatu Analysis");
        buton1.setOnAction(e -> {

            try {
                Matatu_daily_analysis();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            window.close();

        });

        Button buton2 = new Button("Daily owner Analysis");
        buton2.setOnAction(e -> {

            try {
                OwnerDailyAnalysis();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            window.close();

        });

        Button buton3 = new Button("Sacco Daily Analysis");
        buton3.setOnAction(e -> {

            try {
                SaccoAnalysis();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            window.close();


        });
        VBox v1= new VBox(30);
        v1.getChildren().addAll(buton1,buton2,buton3,label1);
        v1.setAlignment(Pos.CENTER);

        Scene Sce1 =new Scene(v1,400,400);

      window.setScene(Sce1);
        window.showAndWait();

    }
    public static void Matatu_daily_analysis() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("MatatuDailyAnalysis/MatatuDay_analysis.fxml"));
        layout6=loaad.load();

        Scene set=new Scene(layout6);

        primaryStage.setScene(set);
        primaryStage.show();
        primaryStage.setFullScreen(false);
    }
    public static void matatuMonthAnalysis() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("MatatuDailyAnalysis/MatatuMonth_analysis.fxml"));
        layout8=loaad.load();

        Scene set=new Scene(layout8);

        primaryStage.setScene(set);
        primaryStage.show();
    }
    public static void OwnerDailyAnalysis() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("OwnerAnalysis/OwnerDaily.fxml"));
        layout9=loaad.load();

        Scene set=new Scene(layout9);

        primaryStage.setScene(set);
        primaryStage.show();
    }
    public static void OwnerMonthAnalysis() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("OwnerAnalysis/ownerMonthly.fxml"));
        layout10=loaad.load();

        Scene set=new Scene(layout10);

        primaryStage.setScene(set);
        primaryStage.show();
    }
    public static void SaccoAnalysis() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("SaccoAnalysis/SaccoAnalysis.fxml"));
        layout11=loaad.load();

        Scene set=new Scene(layout11);

        primaryStage.setScene(set);
        primaryStage.show();
    }
    public static void checkconnection(){

        conn =Sql_Connection.DbConnector();

        if (conn == null) {

        System.out.println("connection is not successfull");
        System.exit(1);
        }
        else {
            System.out.println("connection is succesful");

        }
        }

    public static void loginform() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("login_form/login.fxml"));
        layout13=loaad.load();



        Scene set=new Scene(layout13);

        primaryStage.setScene(set);
        primaryStage.show();

        primaryStage.setResizable(false);
    }
    public static void signup() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("SIGNUP/signUp form.fxml"));
        v1=loaad.load();

        Scene set=new Scene(v1);

        primaryStage.setScene(set);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public static void showdialog(){

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("informaton Dialogue");
        alert.setHeaderText(null);
        alert.setContentText("Records have been successfully saved ");
        alert.showAndWait();
    }
    public static void showMatRegistered() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("registeredMatatu/registeredmatatu.fxml"));
        v1=loaad.load();

        Scene set=new Scene(v1);

        primaryStage.setScene(set);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public static void showdriverRegistered() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("driverRegistered/driverRegistered.fxml"));
        v1=loaad.load();

        Scene set=new Scene(v1);

        primaryStage.setScene(set);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void showOwnerRegistered() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("OwnerRegistered/ownerRegistered.fxml"));
        v1=loaad.load();

        Scene set=new Scene(v1);

        primaryStage.setScene(set);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public static void showMattransDetails() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("matatu_transView/matTransView.fxml"));
        v1=loaad.load();

        Scene set=new Scene(v1);

        primaryStage.setScene(set);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public static void showOwnerPayDetail() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("ownerPay_Details/ownerpay detail.fxml"));
        v1=loaad.load();

        Scene set=new Scene(v1);

        primaryStage.setScene(set);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public static void showsaccoTransDetail() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("saccoTrans_details/saccoTrans_detail.fxml"));
        v1=loaad.load();

        Scene set=new Scene(v1);

        primaryStage.setScene(set);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public static void driverregistered() throws IOException {
        FXMLLoader loaad=new FXMLLoader();
        loaad.setLocation(Main.class.getResource("DriverRegistered/DriverDetails.fxml"));
        v1=loaad.load();

        Scene set=new Scene(v1);

        primaryStage.setScene(set);
        primaryStage.show();
        primaryStage.setResizable(false);
    }





    public static void main(String[] args) {
        launch(args);


    }
}
