package interfacesGrafica;

import javax.swing.JPanel;

import interfacesGrafica.Ventana;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.Mapa;
import clases.Personaje;
import clasesDAO.Arquero;
import clasesDAO.Guerrero;
import clasesDAO.Mago;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;

public class SeleccionPersonaje extends JPanel {

	private Ventana ventana;

	public SeleccionPersonaje(Ventana v) throws SQLException {
		setBackground(Color.BLACK);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 450, 0 };
		gridBagLayout.rowHeights = new int[] { 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel titulo = new JLabel("Bienvenido a Dungeons & Goblins, elija su clase:\n");
		titulo.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		titulo.setForeground(Color.GREEN);
		titulo.setBackground(Color.BLACK);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.anchor = GridBagConstraints.NORTH;
		gbc_titulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_titulo.gridx = 2;
		gbc_titulo.gridy = 2;
		add(titulo, gbc_titulo);
		
				JButton mago_1 = new JButton("Mago");
				mago_1.setForeground(Color.GREEN);
				mago_1.setBackground(Color.BLACK);
				mago_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							Mapa mapa = new Mapa();
							Mago mago = new Mago();

							System.out.println(mago);
							System.out.println(mapa);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
				
						JButton arquero_1 = new JButton("Arquero");
						arquero_1.setForeground(Color.GREEN);
						arquero_1.setBackground(Color.BLACK);
						arquero_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

								try {
									Mapa mapa = new Mapa();
									Arquero arquero = new Arquero();

									System.out.println(arquero);
									System.out.println(mapa);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						
								JButton guerrero_1 = new JButton("Guerrero");
								guerrero_1.setForeground(Color.GREEN);
								guerrero_1.setBackground(Color.BLACK);
								guerrero_1.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										Mapa mapa;
										try {
											Guerrero guerrero = new Guerrero();

											mapa = new Mapa();
											System.out.println(mapa);
											System.out.println(guerrero);

										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}

									}
								});
								GridBagConstraints gbc_guerrero_1 = new GridBagConstraints();
								gbc_guerrero_1.insets = new Insets(0, 0, 5, 0);
								gbc_guerrero_1.gridx = 2;
								gbc_guerrero_1.gridy = 7;
								add(guerrero_1, gbc_guerrero_1);
						GridBagConstraints gbc_arquero_1 = new GridBagConstraints();
						gbc_arquero_1.insets = new Insets(0, 0, 5, 0);
						gbc_arquero_1.gridx = 2;
						gbc_arquero_1.gridy = 8;
						add(arquero_1, gbc_arquero_1);
				GridBagConstraints gbc_mago_1 = new GridBagConstraints();
				gbc_mago_1.gridx = 2;
				gbc_mago_1.gridy = 9;
				add(mago_1, gbc_mago_1);

	}

}
