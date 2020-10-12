import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class AbrirImagemFrame extends JFrame {

	private JPanel contentPane;
	static JLabel lblSelecionarImagem = new JLabel("");

	static JFileChooser chooser = new JFileChooser();
	static File f;
	ImageIcon icon;
	
	public static final String PATH = ".\\";

	private static JTextField textField = new JTextField();
	private final JButton btnEqualizar = new JButton("Equalizar/Salvar");

	public AbrirImagemFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.setFont(new Font("Arial", Font.BOLD, 15));
		btnCarregar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CarregarActionPerformed(evt);
			}
		});

		JLabel lblEqualizadorDeImagem = new JLabel("Equalizador de Imagem");
		lblEqualizadorDeImagem.setFont(new Font("Arial", Font.BOLD, 20));
		btnEqualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					EqualizarActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnEqualizar.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblEqualizarImagemE = new JLabel("Equalizar Imagem e Salvar");
		lblEqualizarImagemE.setFont(new Font("Arial", Font.BOLD, 15));
		lblEqualizarImagemE.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.setFont(new Font("Arial", Font.BOLD, 10));
		btnInfo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				InfoActionPerformed(evt);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCarregar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEqualizadorDeImagem, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEqualizar)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEqualizarImagemE)
							.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
							.addComponent(btnInfo)))
					.addContainerGap())
				.addComponent(lblSelecionarImagem, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEqualizadorDeImagem, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEqualizarImagemE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCarregar)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEqualizar)))
						.addComponent(btnInfo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSelecionarImagem, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void CarregarImg() {

	}

	public static void CarregarActionPerformed(ActionEvent e) {
		chooser.showOpenDialog(null);
		f = chooser.getSelectedFile();
		String foto = f.getPath();
		textField.setText(foto);
		ImageIcon imageIcon = new ImageIcon(f.getPath());
		Image img = imageIcon.getImage();
		Image newimg = img.getScaledInstance(img.getWidth(null), img.getHeight(null), java.awt.Image.SCALE_SMOOTH);

		ImageIcon icon = new ImageIcon(newimg);
		lblSelecionarImagem.setIcon(icon);
	}

	public void EqualizarActionPerformed(ActionEvent e) throws IOException {
		BufferedImage imgE = ImageIO.read(f);
		BufferedImage newEq = EqualizarImagem.equalização(imgE);

		ImageIcon icon = new ImageIcon(newEq);
		lblSelecionarImagem.setIcon(icon);
		
		ImageIO.write(newEq, "png", new File(PATH, f.getName()));
	}
	
	public void InfoActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"1 - Clique em carregar para selecionar uma imagem. \n"
				+ "2 - Ao clicar em Equalziar/Salvar a imagem carrega será equalizada e será salva automaticamente na pasta do programa. \n" 
				+ "3 -  Não é possivel salvar mais de uma mesma imagem \n."
				+ "4 - Se a imagem for maior que a tela,ela será equalizada do mesmo jeito.");
	
	}
}
