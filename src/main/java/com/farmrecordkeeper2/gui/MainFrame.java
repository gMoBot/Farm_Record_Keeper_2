package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.AppConfig;
import main.java.com.farmrecordkeeper2.controller.Controller;
import main.java.com.farmrecordkeeper2.dao.DatabaseDAO;
import main.java.com.farmrecordkeeper2.testservice.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;

/**
 * Created by garrettcoggon on 7/2/15.
 */
public class MainFrame extends JFrame{
//    private TextPanel textPanel;
    private ToolBar toolBar;
    private FormPanel formPanel;
    private JFileChooser jFileChooser;
    private Controller controller;
    private TablePanel tablePanel;
    private PrefsDialog prefsDialog;
    private Preferences preferences;

//    @Autowired
//    private DatabaseDAO databaseDAO;

    //TODO: intercept window closing to disconnect from db-maybe different with hiberate-check

    public MainFrame(){
        super("Farm Records App");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService service = context.getBean("customerService", CustomerService.class);
        System.out.println(service.findAll().get(0).getFirstname());

        Controller controller1 = context.getBean("controller", Controller.class);
//        System.out.println(controller1.);
        controller1.doSomething();


//        databaseDAO.getApplications();


        toolBar = new ToolBar();
        tablePanel = new TablePanel();
        formPanel = new FormPanel();

//        controller = new Controller();




        formPanel.setApplFormListener(new ApplFormListener() {
            @Override
            public void applFormEventOccured(FormEvent e) {
                String block = e.getBlock();
                String date = e.getDate();
                String time = e.getTime();
                String appl = e.getAppl();
                String target = e.getTarget();
                String product = e.getProduct();
                String rate = e.getRate();
                String notes = e.getNotes();

                System.out.println("Main frame: " + block + date + time + appl + target + product +
                        rate + notes + "\n");

                controller.addAppl(e);
            }
        });

        toolBar.setToolBarListener(new ToolBarListener() {
            @Override
            public void saveEventOccurred() {
                System.out.print("save");

                controller.save();
            }

            @Override
            public void refreshEventOccurred() {

                //TODO: refresh Table Data
                System.out.print("refresh");
                controller.getApplications();
            }
        });


        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);

        // MainFrame Window Settings
        setMinimumSize(new Dimension(500, 450));
        setSize(550, 425);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }





}
