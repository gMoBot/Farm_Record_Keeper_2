package main.java.com.farmrecordkeeper2.gui;

import main.java.com.farmrecordkeeper2.AppConfig;
import main.java.com.farmrecordkeeper2.controller.Controller;
import main.java.com.farmrecordkeeper2.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.prefs.Preferences;

/**
 * Created by garrettcoggon on 7/2/15.
 */

public class MainFrame extends JFrame{

    private ToolBar toolBar;
    private AppFormPanel appFormPanel;
    private FarmFormPanel farmFormPanel;
    private BlockFormPanel blockFormPanel;
    private ApplProfileFormPanel applProfileFormPanel;
    private ProductFormPanel productFormPanel;
    private JFileChooser jFileChooser;
    private Controller controller;
    private AppTablePanel appTablePanel;
    private PrefsDialog prefsDialog;
    private Preferences preferences;
    private BlockTablePanel blockTablePanel;
    private ApplicatorTablePanel applicatorTablePanel;
    private ProductTablePanel productTablePanel;


    public MainFrame(){
        super("Farm Records App");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        controller = context.getBean("controller", Controller.class);

        toolBar = new ToolBar();
        appTablePanel = new AppTablePanel();
        appFormPanel = new AppFormPanel(getBlocks(), getApplicatorProfiles(), getProducts());
        prefsDialog = new PrefsDialog(this);
        farmFormPanel = new FarmFormPanel(getFarm());
        blockFormPanel = new BlockFormPanel(getFarm());
        applProfileFormPanel = new ApplProfileFormPanel();
        productFormPanel = new ProductFormPanel();
        blockTablePanel = new BlockTablePanel();
        applicatorTablePanel = new ApplicatorTablePanel();
        productTablePanel = new ProductTablePanel();


        farmFormPanel.setVisible(false);
        blockFormPanel.setVisible(false);
        applProfileFormPanel.setVisible(false);
        productFormPanel.setVisible(false);

        blockTablePanel.setVisible(false);
        applicatorTablePanel.setVisible(false);
        productTablePanel.setVisible(false);

        preferences = Preferences.userRoot().node("db");

        appTablePanel.setData(controller.getApplications());

        setApplicationTableListener();
        setBlockTableListener();
        setApplicatorTableListener();
        setProductTableListener();


        jFileChooser = new JFileChooser();
        jFileChooser.addChoosableFileFilter(new ApplicationFileFilter());
        jFileChooser.addChoosableFileFilter(new CSVFIleFilter());
        setJMenuBar(createMenuBar());


        prefsDialog.setPrefsListener(new PrefsListener() {
            @Override
            public void preferencesSet(String user, String password, int port) {
                preferences.put("user", user);
                preferences.put("password", password);
                preferences.putInt("port", port);
            }
        });

        String user = preferences.get("user", "");
        String password = preferences.get("password", "");
        int port = preferences.getInt("port", 7532);
        prefsDialog.setDefaults(user, password, port);


        setApplFormListener();
        setFarmFormListener();
        setBlockFormListener();
        setApplProfileFormListener();
        setProductFormListener();

        toolBar.setToolBarListener(new ToolBarListener() {
            @Override
            public void newApplicationEventOccurred() {
                remove(farmFormPanel);
                remove(blockFormPanel);
                remove(applProfileFormPanel);
                remove(productFormPanel);

                appFormPanel = new AppFormPanel(getBlocks(), getApplicatorProfiles(), getProducts());
                setApplFormListener();

                add(appFormPanel, BorderLayout.WEST);
                appFormPanel.setEnabled(true);
                appFormPanel.setVisible(true);

                revalidate();
                repaint();

            }

            @Override
            public void editFarmEventOccurred() {
                remove(appFormPanel);
                remove(blockFormPanel);
                remove(applProfileFormPanel);
                remove(productFormPanel);

                farmFormPanel = new FarmFormPanel(getFarm());
                setFarmFormListener();

                add(farmFormPanel, BorderLayout.WEST);
                farmFormPanel.setVisible(true);
                revalidate();
                repaint();
            }

            @Override
            public void newBlockEventOccurred() {
                remove(appFormPanel);
                remove(farmFormPanel);
                remove(applProfileFormPanel);
                remove(productFormPanel);

                blockFormPanel = new BlockFormPanel(getFarm());
                setBlockFormListener();

                add(blockFormPanel, BorderLayout.WEST);
                blockFormPanel.setVisible(true);

                revalidate();
                repaint();
            }

            @Override
            public void newApplicatorEventOccurred() {
                remove(appFormPanel);
                remove(blockFormPanel);
                remove(productFormPanel);
                remove(farmFormPanel);

                applProfileFormPanel = new ApplProfileFormPanel();
                setApplProfileFormListener();

                add(applProfileFormPanel, BorderLayout.WEST);
                applProfileFormPanel.setVisible(true);

                revalidate();
                repaint();
            }

            @Override
            public void newProductEventOccurred() {
                remove(appFormPanel);
                remove(blockFormPanel);
                remove(applProfileFormPanel);
                remove(farmFormPanel);

                productFormPanel = new ProductFormPanel();
                setProductFormListener();

                add(productFormPanel, BorderLayout.WEST);
                productFormPanel.setVisible(true);

                revalidate();
                repaint();
            }

            @Override
            public void showAppsEventOccurred() {
                remove(blockTablePanel);
                remove(applicatorTablePanel);
                remove(productTablePanel);
                setApplicationTableListener();

                appTablePanel.setData(controller.getApplications());

                add(appTablePanel, BorderLayout.CENTER);
                appTablePanel.setVisible(true);
                appTablePanel.refresh();
            }

            @Override
            public void showBlocksEventOccurred() {
                remove(appTablePanel);
                remove(applicatorTablePanel);
                remove(productTablePanel);

                setBlockTableListener();
                blockTablePanel.setData(controller.getBlocks());

                add(blockTablePanel, BorderLayout.CENTER);
                blockTablePanel.setVisible(true);
                blockTablePanel.refresh();
            }

            @Override
            public void showProductsEventOccurred() {
                remove(appTablePanel);
                remove(applicatorTablePanel);
                remove(blockTablePanel);

                setProductTableListener();
                productTablePanel.setData(controller.getProducts());

                add(productTablePanel, BorderLayout.CENTER);
                productTablePanel.setVisible(true);
                productTablePanel.refresh();
            }

            @Override
            public void showAppProfileEventOccurred() {
                remove(appTablePanel);
                remove(productTablePanel);
                remove(blockTablePanel);

                setApplProfileFormListener();
                applicatorTablePanel.setData(controller.getApplicatorProfiles());

                add(applicatorTablePanel, BorderLayout.CENTER);
                applicatorTablePanel.setVisible(true);
                applicatorTablePanel.refresh();
            }
        });


        add(appFormPanel, BorderLayout.WEST);
        add(appTablePanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);

        // MainFrame Window Settings
        setMinimumSize(new Dimension(600, 600));
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setBlockTableListener() {
        blockTablePanel.setBlockTableListener(new BlockTableListener() {
            @Override
            public void rowDeleted(int row, int tableRow) {

                List<Application> referencedApplications = controller.getBlockApplications(row);
                if (referencedApplications.isEmpty()){
                    System.out.println("No apps found");

                    blockTablePanel.rowsDeleted(tableRow);

                    controller.removeBlock(row);
                    blockTablePanel.setData(controller.getBlocks());
                    blockTablePanel.refresh();
                }
                else{
                    System.out.println("Apps found");
                }


            }
        });
    }

    private void setApplicationTableListener() {
        appTablePanel.setApplicationTableListener(new ApplicationTableListener() {
            @Override
            public void rowDeleted(int row) {
                controller.removeApplication(row);
                appTablePanel.setData(controller.getApplications());
                appTablePanel.refresh();
            }
        });
    }

    private void setApplicatorTableListener(){
        applicatorTablePanel.setApplicatorTableListener(new ApplicatorTableListener() {
            @Override
            public void rowDeleted(int row) {
                controller.removeApplicator(row);
                applicatorTablePanel.setData(controller.getApplicatorProfiles());
                applicatorTablePanel.refresh();
            }
        });
    }

    private void setProductTableListener(){
        productTablePanel.setProductTableListener(new ProductTableListener() {
            @Override
            public void rowDeleted(int row) {
                controller.removeProduct(row);
                productTablePanel.setData(controller.getProducts());
                productTablePanel.refresh();
            }
        });
    }

    private void setProductFormListener() {
        productFormPanel.setProductFormListener(new ProductFormListener() {
            @Override
            public void productFormEventOccurred(ProductFormEvent e) {
                controller.addProduct(e);

                if(productTablePanel != null){
                    productTablePanel.setData(controller.getProducts());
                    productTablePanel.refresh();
                }
            }
        });
    }

    private void setApplProfileFormListener() {
        applProfileFormPanel.setApplProfileFormListener(new ApplProfileFormListener() {
            @Override
            public void applProfileFormEventOccurred(ApplProfileFormEvent e) {
                controller.addApplProfile(e);

                if (applicatorTablePanel != null) {
                    applicatorTablePanel.setData(controller.getApplicatorProfiles());
                    applicatorTablePanel.refresh();
                }
            }
        });
    }

    private void setFarmFormListener() {
        farmFormPanel.setFarmFormListener(new FarmFormListener() {
            @Override
            public void farmFormEventOccurred(FarmFormEvent e) {
                controller.editFarm(e);
            }
        });
    }

    private void setApplFormListener() {
        appFormPanel.setApplFormListener(new ApplFormListener() {
            @Override
            public void appFormEventOccurred(AppFormEvent e) {
                controller.addAppl(e);

                if(appTablePanel != null) {
                    appTablePanel.setData(controller.getApplications());
                    appTablePanel.refresh();
                }
            }
        });
    }

    private void setBlockFormListener() {
        blockFormPanel.setBlockFormListener(new BlockFormListener() {
            @Override
            public void blockFormEventOccurred(BlockFormEvent e) {
                controller.addBlock(e);
                if (blockTablePanel != null) {
                    blockTablePanel.setData(controller.getBlocks());
                    blockTablePanel.refresh();
                }
            }
        });
    }

    private List<Product> getProducts() {
        return controller.getProducts();
    }

    private List<ApplicatorProfile> getApplicatorProfiles() {
        return controller.getApplicatorProfiles();
    }

    private Farm getFarm(){
        return controller.getFarm().get(0);
    }

    private List<Block> getBlocks() {
        return controller.getBlocks();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu windowMenu = new JMenu("Window");

        JMenuItem exportMIDataItem = new JMenuItem("Export MI Data...");
        JMenuItem exportFederalDataItem = new JMenuItem("Export Federal Data...");
        JMenuItem exportProcessorDataItem = new JMenuItem("Export Processor Data...");

        JMenuItem exitItem = new JMenuItem("Exit");

        JMenuItem prefsItem = new JMenuItem("Preferences...");

        windowMenu.add(prefsItem);

        fileMenu.add(exportMIDataItem);
        fileMenu.add(exportProcessorDataItem);
        fileMenu.add(exportFederalDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        prefsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prefsDialog.setVisible(true);
            }
        });


        // for mac ctrl+option/alt+indicated key //
        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_Q);


        prefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.META_MASK));


        // Look and Feel component here is strange, but seems to be specific to mac... //
        // could implement custom Look and Feel to try and improve //
        exportMIDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jFileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveMIDataToFile(jFileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to " +
                                "file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exportFederalDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jFileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveFederalDataToFile(jFileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to " +
                                "file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exportProcessorDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jFileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveProcessorDataToFile(jFileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to " +
                                "file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure you want" +
                        " to exit the application?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
                if(action == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        return menuBar;

    }


}
