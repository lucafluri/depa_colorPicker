import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;

public class colorPicker {
    //Declare all Variables
    private Frame f;
    private JPanel panelUpper;
    private JPanel panelUpSlider;
    private JPanel panelUpText;
    private JPanel panelUpLabel;
    private JPanel panelLower;
    private JPanel panelLowRect;
    private JPanel panelLowRadio;
    private JPanel panelLowButtons;
    private MenuBar menuBar;
    private Menu menu1, menu2;
    private MenuItem m1Item1, m1Item2, m2Item1, m2Item2, m2Item3;
    private JSlider RSlider;
    private JSlider GSlider;
    private JSlider BSlider;
    private TextField RInput;
    private TextField GInput;
    private TextField BInput;
    private Label RLabel;
    private Label GLabel;
    private Label BLabel;
    private Label colorRectangle;
    private JRadioButton radioRed;
    private JRadioButton radioblue;
    private JRadioButton radiogreen;
    private JRadioButton radioyellow;
    private JRadioButton radiocyan;
    private JRadioButton radioorange;
    private JRadioButton radioblack;
    private JRadioButton radiowhite;
    private JButton darkerButton;
    private JButton brighterButton;


    //Data
    private int rValue;
    private int gValue;
    private int bValue;
    private int rHexValue;
    private int gHexValue;
    private int bHexValue;




    private void setup(){
        f = new JFrame("Color Picker by Luca Fluri");

        menuBar = new MenuBar();

        //Creating Menu1
        menu1 = new Menu("File");
        m1Item1 = new MenuItem("Item 1");
        m1Item2 = new MenuItem("Exit");

        //Creating Menu2
        menu2 = new Menu("Attributes");
        m2Item1 = new MenuItem("gray");
        m2Item2 = new MenuItem("pink");
        m2Item3 = new MenuItem("yellow");

        //Add MenuItems to menus
        menu1.add(m1Item1);
        menu1.add(m1Item2);

        menu2.add(m2Item1);
        menu2.add(m2Item2);
        menu2.add(m2Item3);


        menuBar.add(menu1);
        menuBar.add(menu2);


        //Init Panel 1 (Upper)
        panelUpper = new JPanel();
        panelUpper.setLayout(new BorderLayout());

        //Init nested Panels
        panelUpSlider = new JPanel();
        panelUpSlider.setLayout(new BorderLayout());

        panelUpText = new JPanel();
        panelUpText.setLayout(new BorderLayout());

        panelUpLabel = new JPanel();
        panelUpLabel.setLayout(new BorderLayout());



        //Slider
        RSlider = new JSlider(0, 255, 0);
        GSlider = new JSlider(0, 255, 0);
        BSlider = new JSlider(0, 255, 0);

        //TextFields
        RInput = new TextField();
        GInput = new TextField();
        BInput = new TextField();

        //Labels
        RLabel = new Label();
        GLabel = new Label();
        BLabel = new Label();

        //Add all elements to nested panels
        panelUpSlider.add(RSlider, BorderLayout.NORTH);
        panelUpSlider.add(GSlider, BorderLayout.CENTER);
        panelUpSlider.add(BSlider, BorderLayout.SOUTH);
        panelUpText.add(RInput, BorderLayout.NORTH);
        panelUpText.add(GInput, BorderLayout.CENTER);
        panelUpText.add(BInput, BorderLayout.SOUTH);
        panelUpLabel.add(RLabel, BorderLayout.NORTH);
        panelUpLabel.add(GLabel, BorderLayout.CENTER);
        panelUpLabel.add(BLabel, BorderLayout.SOUTH);


        //add nested panels to main panel
        panelUpper.add(panelUpSlider, BorderLayout.WEST);
        panelUpper.add(panelUpText, BorderLayout.CENTER);
        panelUpper.add(panelUpLabel, BorderLayout.EAST);


        //Init lower panel
        panelLower = new JPanel();
        panelLower.setLayout(new BorderLayout());

        //nested panels
        panelLowRect = new JPanel();
        panelLowRect.setLayout(new BorderLayout());

        panelLowRadio = new JPanel();
        panelLowRadio.setLayout(new GridLayout(0, 1));

        panelLowButtons = new JPanel();
        panelLowButtons.setLayout(new BorderLayout());

        colorRectangle = new Label("INSERT RECT HERE");

        radioRed = new JRadioButton("red");
        radiogreen = new JRadioButton("green");
        radioblue = new JRadioButton("blue");
        radiocyan= new JRadioButton("cyan");
        radioyellow= new JRadioButton("yellow");
        radioorange= new JRadioButton("orange");
        radioblack= new JRadioButton("black");
        radiowhite= new JRadioButton("white");

        darkerButton = new JButton("Darker");
        brighterButton = new JButton("Brighter");

        //Add all elemetns to lower nested panels


        panelLowRect.add(colorRectangle, BorderLayout.CENTER);

        panelLowRadio.add(radioRed);
        panelLowRadio.add(radiogreen);
        panelLowRadio.add(radioblue);
        panelLowRadio.add(radiocyan);
        panelLowRadio.add(radioyellow);
        panelLowRadio.add(radioorange);
        panelLowRadio.add(radioblack);
        panelLowRadio.add(radiowhite);

        panelLowButtons.add(darkerButton, BorderLayout.NORTH);
        panelLowButtons.add(brighterButton, BorderLayout.CENTER);


        panelLower.add(panelLowRect, BorderLayout.WEST);
        panelLower.add(panelLowRadio, BorderLayout.CENTER);
        panelLower.add(panelLowButtons, BorderLayout.EAST);


        //Add panels to frame
        f.setLayout(new BorderLayout());
        f.add(panelUpper, BorderLayout.NORTH);
        f.add(panelLower, BorderLayout.CENTER);

        f.setMenuBar(menuBar);
        f.setSize(500, 400);
        f.setVisible(true);

    }

    private void setHandlers(){
        m1Item2.addActionListener(e -> {
            System.exit(0);
        });


        f.addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void setupBinding(){
        //Slider -> TextField
        RSlider.addChangeListener(e -> {
            RInput.setText(String.valueOf(RSlider.getValue()));
        });
        GSlider.addChangeListener(e -> {
            GInput.setText(String.valueOf(GSlider.getValue()));
        });
        BSlider.addChangeListener(e -> {
            BInput.setText(String.valueOf(BSlider.getValue()));
        });

        //TextField -> Slider
        //TODO

    }




    colorPicker(){
        setup();
        setHandlers();
        setupBinding();

    }

    public static void main(String args[]){
        colorPicker c = new colorPicker();
    }
}
