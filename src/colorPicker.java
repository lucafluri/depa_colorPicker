import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;

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
    private TextField RLabel;
    private TextField GLabel;
    private TextField BLabel;
    private Panel colorRectangle;
    private JRadioButton radioRed;
    private JRadioButton radioblue;
    private JRadioButton radiogreen;
    private JRadioButton radioyellow;
    private JRadioButton radiocyan;
    private JRadioButton radioorange;
    private JRadioButton radioblack;
    private JRadioButton radiowhite;
    private JRadioButton[] radioButtons;
    private JButton darkerButton;
    private JButton brighterButton;


    //Data
    private Color color;



    private void setup(){
        f = new JFrame("Color Picker by Luca Fluri");

        menuBar = new MenuBar();


        Random rand = new Random();
        color = new Color(rand.nextInt(256),rand.nextInt(256), rand.nextInt(256));

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
        RInput = new TextField("0");
        GInput = new TextField("0");
        BInput = new TextField("0");

        //Labels
        RLabel = new TextField("0");
        GLabel = new TextField("0");
        BLabel = new TextField("0");

        RLabel.disable();
        GLabel.disable();
        BLabel.disable();

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

        colorRectangle = new Panel();
        colorRectangle.setBackground(color);
        colorRectangle.setSize(200, 200);
        colorRectangle.setPreferredSize(new Dimension(200, 200));

        radioRed = new JRadioButton("red");
        radiogreen = new JRadioButton("green");
        radioblue = new JRadioButton("blue");
        radiocyan= new JRadioButton("cyan");
        radioyellow= new JRadioButton("yellow");
        radioorange= new JRadioButton("orange");
        radioblack= new JRadioButton("black");
        radiowhite= new JRadioButton("white");

        //Creating RadioButton Array for easier user later
        radioButtons = new JRadioButton[8];
        radioButtons[0] = radioRed;
        radioButtons[1] = radiogreen;
        radioButtons[2] = radioblue;
        radioButtons[3] = radiocyan;
        radioButtons[4] = radioyellow;
        radioButtons[5] = radioorange;
        radioButtons[6] = radioblack;
        radioButtons[7] = radiowhite;


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

        updateAll();

    }

    private void setColor(int r, int g, int b){
        color = new Color(r, g, b);
    }

    private void setRed(int r){
        color = new Color(r, color.getGreen(), color.getBlue());
    }

    private void setGreen(int g){
        color = new Color(color.getRed(), g, color.getBlue());
    }

    private void setBlue(int b){
        color = new Color(color.getRed(), color.getGreen(), b);

    }

    private int getRed(){return color.getRed();}
    private int getGreen(){return color.getGreen();}
    private int getBlue(){return color.getBlue();}

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
            //Write Slider Value to "model"
            setRed(RSlider.getValue());
            updateAll();
        });
        GSlider.addChangeListener(e -> {
            setGreen(GSlider.getValue());
            updateAll();
        });
        BSlider.addChangeListener(e -> {
            setBlue(BSlider.getValue());
            updateAll();
        });

        //TextField -> Slider
        RInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int parsed = Integer.parseInt(RInput.getText());
                   setRed(parsed >=0 && parsed < 256 ? parsed : 0);
                    updateAll();
                }catch (Exception ignored){}
            }
        });
        GInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int parsed = Integer.parseInt(GInput.getText());
                    setGreen(parsed >=0 && parsed < 256 ? parsed : 0);
                    updateAll();
                }catch (Exception ignored){}
            }
        });
        BInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int parsed = Integer.parseInt(BInput.getText());
                    setBlue(parsed >=0 && parsed < 256 ? parsed : 0);
                    updateAll();
                }catch (Exception ignored){}
            }
        });

        //Darker/Brighter Button
        darkerButton.addActionListener(e -> {
            color = color.darker();
            updateAll();
        });
        brighterButton.addActionListener(e -> {
            color = color.brighter();
            updateAll();
        });

        //Radio Buttons
        radioRed.addActionListener(e -> {
            color = Color.red;
            updateAll();
        });
        radiogreen.addActionListener(e -> {
            color = Color.green;
            updateAll();
        });
        radioblue.addActionListener(e -> {
            color = Color.blue;
            updateAll();
        });
        radiocyan.addActionListener(e -> {
            color = Color.cyan;
            updateAll();
        });
        radioyellow.addActionListener(e -> {
            color = Color.yellow;
            updateAll();
        });
        radioorange.addActionListener(e -> {
            color = Color.orange;
            updateAll();
        });
        radioblack.addActionListener(e -> {
            color = Color.black;
            updateAll();
        });
        radiowhite.addActionListener(e -> {
            color = Color.white;
            updateAll();
        });


        //Menu Attributes
        m2Item1.addActionListener(e -> { //gray
            color = Color.gray;
            updateAll();
        });
        m2Item2.addActionListener(e -> { //pink
            color = Color.pink;
            updateAll();
        });
        m2Item3.addActionListener(e -> { //yellow
            color = Color.yellow;
            updateAll();
        });

















    }

    private void updateAll(){
        RSlider.setValue(getRed());
        GSlider.setValue(getGreen());
        BSlider.setValue(getBlue());

        RInput.setText(Integer.toString(getRed()));
        GInput.setText(Integer.toString(getGreen()));
        BInput.setText(Integer.toString(getBlue()));

        RLabel.setText(Integer.toHexString(getRed()));
        GLabel.setText(Integer.toHexString(getGreen()));
        BLabel.setText(Integer.toHexString(getBlue()));

        colorRectangle.setBackground(color);


        //Disables Checks
        brighterButton.setEnabled(!color.equals(Color.white));
        darkerButton.setEnabled(!color.equals(Color.black));

        //Radio Buttons

        //Deselect all radiobuttons
        for(JRadioButton r : radioButtons){
            r.setSelected(false);
        }

        if(color.equals(Color.red)){radioRed.setSelected(true);}
        else if(color.equals(Color.green)){radiogreen.setSelected(true);}
        else if(color.equals(Color.blue)){radioblue.setSelected(true);}
        else if(color.equals(Color.cyan)){radiocyan.setSelected(true);}
        else if(color.equals(Color.yellow)){radioyellow.setSelected(true);}
        else if(color.equals(Color.orange)){radioorange.setSelected(true);}
        else if(color.equals(Color.black)){radioblack.setSelected(true);}
        else if(color.equals(Color.white)){radiowhite.setSelected(true);}







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
