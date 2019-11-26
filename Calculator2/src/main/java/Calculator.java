package main.java;

/* Подключаем библиотеки для работы с текстовыми полями, метками, для создания графического окна */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

/* Создаем главный класс программы, реализующий интерфейс ActionListener, 
который отвечает за обработку события нажатия на кнопку.*/
public class Calculator implements ActionListener{
	/* Создаем переменную id типа boolean, в которой хранится состояние авторизации 
	(если авторизация не пройдена, то значение переменной равно false,
	в противном случае true).*/
	private boolean id = false;
	public String a1 = "Message";//public String a1 = "Сообщение"; //текст во всплывающем окошке
	public Color a2 = null;//public Color a2 = Color.GREEN; //цвет поля ввода(верхний)
	public Color a3 = null;//public Color a3 = Color.RED; //цвет поля ввода(нижний)
	public Color a4 = Color.BLACK; //цвет текста текстового поля(верхний)
	public Color a5 = Color.BLACK; //цвет текста текстового поля(нижний)
	public String a6 = "Расчет количества символов в тексте"; //название программы(титулка, заголовок и т. д.)
	public String a7 = "Текст:"; // название текстового поля(верхний)
	public String a8 = "Количество символов в тексте:"; // название текстового поля(нижний)
	public String a9 = "Расчет символов"; // название кнопки(№1)
	public String a10 = "Сброс";// название кнопки(№2)
	public String a11 = "Авторизация";// название кнопки(№3)
	public String a12 = "Расчет точек и запятых";// название кнопки(№4)
	public String a13 = null; // название кнопки для изменения цвета
	public Color a14 = null;//public Color a14 = Color.RED; // цвет кнопки для изменения цвета
	public String a15 = null;// название кнопки для изменения цвета
	public Color a16 = null;//public Color a16 = Color.BLACK; // цвет кнопки для изменения цвета
	public Color a17 = null;//public Color a17 = Color.BLACK; // цвет фона
	public String a18 = "Авторизация"; //название авторизации(титулка, заголовок и т. д.)
	public Color a19 = null;//public Color a2 = Color.GREEN; //цвет поля ввода авторизации(верхний)
	public Color a20 = null;//public Color a3 = Color.RED; //цвет поля ввода авторизации(нижний)
	public Color a21 = Color.BLACK; //цвет текста текстового поля авторизации(верхний)
	public Color a22 = Color.BLACK; //цвет текста текстового поля авторизации(нижний)
	public String a23 = "Авторизоваться"; // название кнопки авторизации(№1)
	public String a24 = "Сброс";// название кнопки авторизации(№2)
	public String a25 = "Логин:"; // название текстового поля авторизации(верхний)
	public String a26 = "Пароль:"; // название текстового поля авторизации(нижний)
	public String a27 = null; // название кнопки для изменения цвета авторизации
	public Color a28 = null;//public Color a14 = Color.RED; // цвет кнопки для изменения цвета авторизации
	public String a29 = null;// название кнопки для изменения цвета авторизации
	public Color a30 = null;//public Color a16 = Color.BLACK; // цвет кнопки для изменения цвета авторизации
	public int count = 0;
        public String a31 = "Message";//public String a31 = "Сообщение"; //текст во всплывающем окошке авторизации
	/* Создаем метод, который изменяет значение 
    переменной id на значение, которое было 
	передано в параметрах метода.*/	
	public void setStateId(boolean id) {
		this.id = id;
	}
	
	/* Создаем метод, который возвращает значение
	переменной id при вызове.*/
	public boolean getStateId() {
		return id;
	}
	
	/* Создаем объект главного окна с помощью ключевого слова new */
    JFrame frame = new JFrame(a6);
	/* Создаем объект панели с метками */
    JPanel panelLeft = new JPanel();
	/* Создаем объект панели с текстовыми полями */
    JPanel panelRight = new JPanel();
	/* Создаем объект панели с кнопками */
    JPanel panelBottom = new JPanel();
	/* Создаем массив текстовых полей */
    public JTextField[] fields = new JTextField[2];

    /* Добавляем конструктор класса */
    public Calculator() {
    	/* Устанавливаем менеджер компоновки для панели с метками и выравнивание по вертикали */
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        /* Устанавливаем размер панели с метками 250 на 300 пикселей */
        panelLeft.setPreferredSize(new Dimension(250, 100));
        /* Устанавливаем менеджер компоновки для панели с текстовыми полями и выравнивание по вертикали */
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        /* Устанавливаем размер панели с текстовыми полями 370 на 300 пикселей */
        panelRight.setPreferredSize(new Dimension(300,100));
        /* Добавляем метки к текстовым полям через метод addLabel */
        addLabel(panelLeft, a7, a4);
        addLabel(panelLeft, a8, a5);
        /* Добавляем текстовые поля через цикл и записываем их в массив */
        for(int i = 0; i < fields.length; i++){
            if(fields.length >= 0){
                /* Записываем ссылку из метода в массив для дальнейшей работы с текстовым полем */
                fields[i] = addTextField(panelRight);
            }
        }
        if (a2 != null) {
        	fields[0].setBackground(a2);
        }
        if (a3 != null) {
        	fields[1].setBackground(a3);
        }
        if (a17 != null) {
        	panelLeft.setBackground(a17);
        	panelRight.setBackground(a17);
        	panelBottom.setBackground(a17);
        }
        /* Добавляем кнопку расчета количества символов */
        JButton calc = addButton(panelBottom, a9);
        //calc.setMargin(new Insets(2,10,2,10));//границы, выравнивание,1-верх,2-лево,3-низ,4-право
        /* Добавляем слушатель на событие нажатия кнопки расчета символов */
        calc.addActionListener(this);
		/* Добавляем кнопку сброса */
        JButton reset = addButton(panelBottom, a10);
       // reset.setMargin(new Insets(2,10,2,10));//границы, выравнивание,1-верх,2-лево,3-низ,4-право
        /* Добавляем слушатель на событие нажатия кнопки сброса */
        reset.addActionListener(this);
		/* Добавляем кнопку авторизации */
        JButton authorization = addButton(panelBottom, a11);
        //authorization.setMargin(new Insets(2,10,2,10));//границы, выравнивание,1-верх,2-лево,3-низ,4-право
        /* Добавляем слушатель на событие нажатия кнопки авторизации*/
        authorization.addActionListener(this);
        /* Добавляем кнопку расчета количества точек и запятых */
        JButton punMarks = addButton(panelBottom, a12);
        //punMarks.setMargin(new Insets(2,10,2,10));//границы, выравнивание,1-верх,2-лево,3-низ,4-право
        /* Добавляем слушатель на событие нажатия кнопки расчета количества точек и запятых */
        punMarks.addActionListener(this);
        /* Делаем главное окно видимым */
        frame.setVisible(true);
        /* Устанавливаем действие при нажатии на крестик - завершение приложения */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Устанавливаем начальное положение главного окна относительно центра экрана (по центру) */
        frame.setLocationRelativeTo(null);
        /* Устанавливаем размер главного окна(600 на 200) */
        frame.setSize(560,140);
        /* Добавляем панель с метками на главное окно */
        frame.add(panelLeft, BorderLayout.WEST);
		/* Добавляем панель с текстовыми полями на главное окно */
        frame.add(panelRight, BorderLayout.EAST);
		/* Добавляем панель с кнопками на главное окно */
        frame.add(panelBottom, BorderLayout.SOUTH);
		/* Запрещаем изменение размеров главного окна */
        frame.setResizable(false);
    }

    /* Метод добавления текстовых меток */
    public void addLabel(JComponent container, String name, Color color){
        /* Создаем объект текстовой метки */
        JLabel label = new JLabel(name);
        /* Устанавливаем максимально допустимый размер метки */
        label.setMaximumSize(new Dimension(250,20));
        /* Устанавливаем цвета текста метки */
        label.setForeground(color);
        label.setOpaque(true);
        /* Устанавливаем выравнивание метки по правому краю */
        label.setHorizontalAlignment(JLabel.RIGHT);
        /* Добавляем рамку вокруг метки */
        label.setBorder(new EtchedBorder());
        /* Добавляем метку на панель */
        container.add(label);
    }

    /* Метод добавления текстовых полей */
    public JTextField addTextField(JComponent container){
        /* Создаем объект текстового поля */
        JTextField field = new JTextField();
        /* Устанавливаем максимально допустимый размер поля */
        field.setMaximumSize(new Dimension(300,20));
        /* Добавляем поле на панель */
        container.add(field);
        /* Возвращаем ссылку на текстовое поле */
        return field;
    }

    /* Метод добавления кнопок */
    public JButton addButton(JComponent container, String name){
        /* Создаем объект кнопки */
        JButton button = new JButton(name);
        
        if (name == a13) {button.setBackground(a14);}
        if (name == a15) {button.setForeground(a16);}
        /* Устанавливаем максимально допустимый размер кнопки */
        button.setMaximumSize(new Dimension(100,20));
        /* Устанавливаем выравнивание по горизонтали (по центру) */
        button.setHorizontalAlignment(JButton.CENTER);
        /* Добавляем кнопку на панель */
        container.add(button);
        /* Возвращаем ссылку на кнопку */
        return button;
    }
    
    /* Метод расчета количества символов */
    public void calculate() throws Exception {
		/* Записываем введенный текст из поля ввода в переменную */
    	String getText = fields[0].getText();
		/* Рассчитываем длину введенного текста */
        String valueOf = String.valueOf(getText.length());
		/* Записываем результат расчета в поле вывода */
        fields[1].setText(valueOf);
    }
    
    /* Метод расчета количества знаков препинания */
    public void calculatePunMarks() throws Exception {
		/* Создаем переменную, в которой хранится
		сумма всех точек и запятых.*/	
    	int valueOf = 0;
		/* Записываем введенный текст из поля ввода в переменную */
    	String getText = fields[0].getText();
		/* Рассчитываем количество точек и запятых с помощью цикла for */
    	for (int i = 0; i < getText.length(); i++) {
			/* Используем условный оператор if
			для увеличения значения переменной valueOf
			каждый раз, когда во введенном наборе символов
			встречается точка или запятая.*/
    		if ((getText.charAt(i) == ',') || (getText.charAt(i) == '.')) {
    			valueOf += 1;
    		}
    	}
		/* Преобразовываем тип переменной valueOf
		из целочисленного типа int в строковый тип String
        и записываем полученное значение в переменную result.*/		
    	String result = String.valueOf(valueOf);
		/* Записываем результат расчета в поле вывода */
        fields[1].setText(result);
    } 

    /* С помощью аннотации @Override указываем, что
	метод, следующий за аннотацией, будет переопределен.*/
    @Override
	/* Метод обработки события нажатия на кнопку */
    
    public void actionPerformed(ActionEvent e) {
        /* С помощью оператора if выполняем действие,
		назначенное на ту кнопку, чье имя совпадаем со
		строкой, которая передается в качестве параметра
		встроенному методу equals.*/
        if (e.getActionCommand().equals("Расчет символов")) {
			/* Обработка исключения на случай возникновения ошибок 
			в процессе выполнения кода, записанного в боке try.*/ 
            try {
                /* Запускаем метод расчета количества символов */
                calculate();
			/* Код, выполняемый при возникновении ошибок 
			в процессе выполнения кода из блока try. */
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
        } else if (e.getActionCommand().equals("Авторизация")) {
        	try {
                /* Создаем объект класса CalcAuthorization */
        		if (getStateId() == false) {frame.setVisible(false);
                CalcAuthorization calcAut = new CalcAuthorization();
        		}
        		if (getStateId() == true) {
        			JOptionPane.showMessageDialog(null, "Вы уже вошли.");
        		}
				/* Запускаем процесс авторизации */
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
        } else if (e.getActionCommand().equals("Расчет точек и запятых")) {
        	try {
				/* Если авторизация не пройдена - выводим предупреждающее 
				сообщение, в противном случае - запускаем метод расчета количества
				точек и запятых. */
                if(getStateId() == false) {
                	JOptionPane.showMessageDialog(null, "Авторизируйтесь, чтобы получить доступ к этой функции",a1,1);
                } else {
                	calculatePunMarks();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            } 
        } else if (e.getActionCommand().equals("Сброс")) {
            /* Очищаем все поля через цикл */
            for(int i=0; i<fields.length; i++){
                fields[i].setText("");
            }
        }
    }
    
    /* Главный метод класса, запускающий калькулятор */
    public static void main(String[] args) {
		/* С помощью метода invokeLater запускаем асинхронную операцию,
		которая сохраняет действие (Runnable), и запускает его на одной
		из следующих итераций цикла сообщений.*/
    	Calculator c = new Calculator();
    	
    }

	

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}

	public void setEnabled(boolean b) {
		frame.setEnabled(b);
		
	}
}
