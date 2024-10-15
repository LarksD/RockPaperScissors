import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    static int contadorVitorias = 0;
    static int contadorVitoriasComputador = 0;
    static JLabel vitorias;

    public static void intro() {
        JOptionPane.showMessageDialog(null, "O famoso Jokenpô, Pedra vence tesoura, tesoura vence papel, papel vence pedra.\nMelhor de três!", "Como Jogar", 1);
    }

    public static void abaJogo() {

        JFrame mainframe = new JFrame("Jokenpô");
        mainframe.getContentPane().setBackground( new Color(38, 0, 110));
        Container panelMain = mainframe.getContentPane();
        panelMain.setLayout(null);

        JLabel titulo = new JLabel("Jokenpô");
        titulo.setBounds(350, 20, 400, 40);
        titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        panelMain.add(titulo);

        ImageIcon originalIcon = new ImageIcon("src/images/rock left.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton buttonRock = new JButton(scaledIcon);
        buttonRock.setBounds(100, 100, 180, 160);
        buttonRock.setBorder(BorderFactory.createEmptyBorder());
        buttonRock.setContentAreaFilled(true);

        ImageIcon orignalIcon2 = new ImageIcon("src/images/paper left.png");
        Image originalImage2 = orignalIcon2.getImage();
        Image scaledImage2 = originalImage2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

        JButton buttonPaper = new JButton(scaledIcon2);
        buttonPaper.setBounds(300, 100, 180, 160);
        buttonPaper.setBorder(BorderFactory.createEmptyBorder());
        buttonPaper.setContentAreaFilled(true);

        ImageIcon orignalIcon3 = new ImageIcon("src/images/scissors left.png");
        Image originalImage3 = orignalIcon3.getImage();
        Image scaledImage3 = originalImage3.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

        JButton buttonScissors = new JButton(scaledIcon3);
        buttonScissors.setBounds(500, 100, 200, 160);
        buttonScissors.setBorder(BorderFactory.createEmptyBorder());
        buttonScissors.setContentAreaFilled(true);

        panelMain.add(buttonRock);
        panelMain.add(buttonPaper);
        panelMain.add(buttonScissors);

        buttonRock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                jogada(0);
            }
        });

        buttonPaper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                jogada(1);
            }
        });

        buttonScissors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                jogada(2);
            }
        });

        vitorias = new JLabel("Vitórias: " + contadorVitorias + " | Derrotas: " + contadorVitoriasComputador);
        vitorias.setBounds(300, 300, 200, 40);
        vitorias.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        vitorias.setForeground(Color.WHITE);
        panelMain.add(vitorias);

        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(800, 400);
        mainframe.setVisible(true);
    }

    private static void jogada(int i) {
        String[] jogadaStrings = {"Pedra", "Papel", "Tesoura"};
        int jogadaComputador = (int) (Math.random() * 3);
        String resultado = "";

        if (jogadaComputador == i) {
            resultado = "Empate!";
        } else if (jogadaComputador == 0 && i == 1 || jogadaComputador == 1 && i == 2 || jogadaComputador == 2 && i == 0) { //pedra == 0, papel == 1, tesoura == 2
            resultado = "Você venceu esta rodada! " + jogadaStrings[i] + " vence " + jogadaStrings[jogadaComputador];
            contadorVitorias++;
        } else {
            resultado = "Você perdeu esta rodada! " + jogadaStrings[jogadaComputador] + " vence " + jogadaStrings[i];
            contadorVitoriasComputador++;

        }
        vitorias.setText("Vitórias: " + contadorVitorias + " | Derrotas: " + contadorVitoriasComputador);
        JOptionPane.showMessageDialog(null, "Sua escolha: "+ jogadaStrings[i] + "\nEscolha do computador: "+ jogadaStrings[jogadaComputador] +"\n" + resultado, "Resultado", 1);
        verificarResultado();
    }

    private static void verificarResultado() {
        if (contadorVitorias == 3) {
            JOptionPane.showMessageDialog(null, "Você venceu o jogo!", "Resultado", 1);
            resetarGame();
        } else if (contadorVitoriasComputador == 3) {
            JOptionPane.showMessageDialog(null, "Você perdeu o jogo!", "Resultado", 1);
            resetarGame();
        }

    }

    private static void resetarGame() {
        contadorVitorias = 0;
        contadorVitoriasComputador = 0;
        vitorias.setText("Vitórias: " + contadorVitorias + " | Derrotas: " + contadorVitoriasComputador);
    }

}
