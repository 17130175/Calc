package main.java;

/* Подключаем библиотеки для работы с текстовыми полями, метками, для создания графического окна */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
который отвечает за обработку события нажатия на кнопку.
*/
public class CalcAuthorization implements ActionListener{
	
	/* Создаем объект окна авторизации с помощью ключевого слова new */
	Calculator c = new Calculator();
    JFrame frameAut = new JFrame(c.a18);
	/* Создаем объект панели с метками */
    JPanel panelLeftAut = new JPanel();
	/* Создаем объект панели с текстовыми полями */
    JPanel panelRightAut = new JPanel();
	/* Создаем объект панели с кнопками */
    JPanel panelBottomAut = new JPanel();
	/* Создаем массив текстовых полей */
    public JTextField[] fieldsAut = new JTextField[2];
     /* Добавляем конструктор класса */
    public CalcAuthorization() {
        /* Устанавливаем менеджер компоновки для панели с метками и выравнивание по вертикали */
        panelLeftAut.setLayout(new BoxLayout(panelLeftAut, BoxLayout.Y_AXIS));
        /* Устанавливаем размер панели с метками 250 на 300 пикселей */
        panelLeftAut.setPreferredSize(new Dimension(200, 100));
        /* Устанавливаем менеджер компоновки для панели с текстовыми полями и выравнивание по вертикали */
        panelRightAut.setLayout(new BoxLayout(panelRightAut, BoxLayout.Y_AXIS));
        /* Устанавливаем  размер 230 на 300 пикселей */
        panelRightAut.setPreferredSize(new Dimension(230,300));
        c.setEnabled(false);
        /* Добавляем метки к текстовым полям через метод addLabel */
        addLabel(panelLeftAut, c.a25, c.a21);
        addLabel(panelLeftAut, c.a26, c.a22);
        /* Добавляем текстовые поля через цикл и записываем их в массив */
        for(int i = 0; i < fieldsAut.length; i++){
            if(fieldsAut.length >= 0){
                /* Записываем ссылку из метода в массив для дальнейшей работы с текстовым полем */
                fieldsAut[i] = addTextField(panelRightAut);}
        }
        if (c.a19 != null) {
        	fieldsAut[0].setBackground(c.a19);
        }
        if (c.a20 != null) {
        	fieldsAut[0].setBackground(c.a20);
        }
        /* Добавляем кнопку подтверждения авторизации */
        JButton signInAut = addButton(panelBottomAut, c.a23);
        //signInAut.setMargin(new Insets(2,10,2,10));//границы, выравнивание,1-верх,2-лево,3-низ,4-право
        /* Добавляем слушатель на событие нажатия */
        signInAut.addActionListener(this);
		/* Добавляем кнопку сброса */
        JButton resetAut = addButton(panelBottomAut, c.a24);
        //resetAut.setMargin(new Insets(2,10,2,10));//границы, выравнивание,1-верх,2-лево,3-низ,4-право
        /* Добавляем слушатель на событие нажатия */
        resetAut.addActionListener(this);

        /* Делаем окно авторизации видимым */
        frameAut.setVisible(true);
        /* Устанавливаем действие при нажатии на крестик - завершение приложения */
        frameAut.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
        	frameAut.dispose();
        	c.setEnabled(true);
        	c.setVisible(true);
        	}
        	});
        /* Устанавливаем начальное положение окна авторизации относительно центра экрана (по центру) */
        frameAut.setLocationRelativeTo(null);
        /* Устанавливаем размер окна авторизации (450 на 200) */
        frameAut.setSize(450,140);
        /* Добавляем панель с метками на окно авторизации */
        frameAut.add(panelLeftAut, BorderLayout.WEST);
		/* Добавляем панель с текстовыми полями на окно авторизации */
        frameAut.add(panelRightAut, BorderLayout.EAST);
		/* Добавляем панель с кнопками на окно авторизации */
        frameAut.add(panelBottomAut, BorderLayout.SOUTH);
		/* Запрещаем изменение размеров окна авторизации */
        frameAut.setResizable(false);
    }

    /* Метод добавления текстовых меток */
    public void addLabel(JComponent container, String name, Color color){
        /* Создаем объект текстовой метки */
        JLabel label = new JLabel(name);
        /* Устанавливаем максимально допустимый размер метки */
        label.setMaximumSize(new Dimension(200,20));
        /* Устанавливаем цвета текста метки */
        label.setForeground(color);
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
        field.setMaximumSize(new Dimension(350,20));
        /* Добавляем поле на панель */
        container.add(field);
        /* Возвращаем ссылку на текстовое поле */
        return field;
    }

    /* Метод добавления кнопок */
    public JButton addButton(JComponent container, String name){
        /* Создаем объект кнопки */
        JButton button = new JButton(name);
        /* Устанавливаем максимально допустимый размер кнопки */
        button.setMaximumSize(new Dimension(100,20));
        /* Устанавливаем выравнивание по горизонтали (по центру) */
        button.setHorizontalAlignment(JButton.CENTER);
        if (name == c.a27) {button.setBackground(c.a28);}
        if (name == c.a29) {button.setForeground(c.a30);}
        /* Добавляем кнопку на панель */
        container.add(button);
        /* Возвращаем ссылку на кнопку */
        return button;
    }
    
    /* Метод прохождения авторизации */
    public void signIn() throws Exception {
		/* Записываем введенный текст из поля ввода логина в переменную */
    	String login = fieldsAut[0].getText();
		/* Записываем введенный текст из поля ввода пароля в переменную */
    	String password = fieldsAut[1].getText();
		/* Создаем массив, который содержит допустимые значения логина */
    	String[] loginArray = {"Ard", "Bay", "Shay", "Step"};
		/* Создаем массив, который содержит допустимые значения пароля */
    	String[] passwordArray = {"17130470", "17130175", "17130180", "17130705"};
    	
		/* Выполняем проверку введенных логина и пароля через цикл for.
		Если введенные значения совпадают со значениями в массивах,
		проверка пройдена успешно и авторизация выполнена. 
		*/
    	for (int i = 0; i < loginArray.length; i++) {
    		if ((login.equals(loginArray[i])) && (password.equals(passwordArray[i]))) {
				/* Создаем объект главного класса Calculator */
        		/* Изменяем значение переменной id в главном классе */
        		c.setStateId(true);
				/* Выводим сообщение об успешном прохождении процесса авторизации */
        		JOptionPane.showMessageDialog(null, "Авторизация пройдена успешно");
				/* Скрываем окно авторизации */
        		frameAut.setVisible(false);
        		c.setVisible(true);
        		c.setEnabled(true);
        		break;
        	} else { if (i == 3) {JOptionPane.showMessageDialog(null, "Проверьте правильность ввода",c.a31,1);}}
    	}
    }
    
    /* С помощью аннотации @Override указываем, что
	метод, следующий за аннотацией, будет переопределен.
	*/	
    @Override
	/* Метод обработки события нажатия на кнопку */
    public void actionPerformed(ActionEvent e) {
        /* С помощью оператора if выполняем действие,
		назначенное на ту кнопку, чье имя совпадаем со
		строкой, которая передается в качестве параметра
		встроенному методу equals.
		*/
        if (e.getActionCommand().equals("Авторизоваться")) {
			/* Обработка исключения на случай возникновения ошибок 
			в процессе выполнения кода, записанного в блоке try. 
			*/
            try {
                /* Запускаем метод авторизации */
            	signIn();
            /* Код, выполняемый при возникновении ошибок 
			в процессе выполнения кода из блока try. 
			*/
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
        } else if (e.getActionCommand().equals("Сброс")) {
            /* Очищаем все поля через цикл */
            for(int i=0; i<fieldsAut.length; i++){
                fieldsAut[i].setText("");
            }
        }
    }
    
    /* Главный метод класса, запускающий процесс авторизации */
    public void runAut() {
    	
		/* С помощью метода invokeLater запускаем асинхронную операцию,
		которая сохраняет действие (Runnable), и запускает его на одной
		из следующих итераций цикла сообщений.
		*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			/* Создаем метод, который запускает процесс авторизации
			через конструктор класса.
			*/
            public void run() {
                new CalcAuthorization();
            }
        });
    }

	public void setVisible(boolean b) {
		frameAut.setVisible(b);
		
	}
}
