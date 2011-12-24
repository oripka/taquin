/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TaquinGUI.java
 *
 * Created on 23.03.2009, 18:42:47
 */

package gui;

import framework.AStar;
import framework.Node;
import game.taquin.Taquin;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

/**
 * User interface to the taquin game uses observer to get notified of statistics
 */
public class TaquinGUI extends javax.swing.JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private JLabel[][] field;
	private Taquin taquin;
	int current = -1;
	String status = "idle";
	SwingWorker<String, Object> worker;
	int random = 100;

	List<Node> solutionList = new ArrayList<Node>();

	/** Creates new form TaquinGUI */
	public TaquinGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		initComponents();
		sliderChanged(null);
		changeRandomization(null);

	}

	private void run(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_run
		final TaquinGUI something = this;
		worker = new SwingWorker<String, Object>() {

			@Override
			protected String doInBackground() throws Exception {
				AStar a = new AStar(taquin);
				a.addObserver(something);
				Node solution = a.astar(this);

				solutionList.clear();
				current = 0;

				if (solution != null) {
					solution.toBottomUpPath(solutionList);
					result.setText("Solution found, depth: "
							+ solutionList.size());
					last();
				} else {
					result.setText("There is no solution");
				}
				return "";
			}

		};
		worker.execute();
	}// GEN-LAST:event_run

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		result = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		slider = new javax.swing.JSlider();
		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		rslider = new javax.swing.JSlider();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		solvable = new javax.swing.JCheckBox();
		jPanel3 = new javax.swing.JPanel();
		randomize = new javax.swing.JButton();
		begin = new javax.swing.JButton();
		back = new javax.swing.JButton();
		forward = new javax.swing.JButton();
		run = new javax.swing.JButton();
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		saveMenuItem = new javax.swing.JMenuItem();
		saveAsMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		editMenu = new javax.swing.JMenu();
		cutMenuItem = new javax.swing.JMenuItem();
		copyMenuItem = new javax.swing.JMenuItem();
		pasteMenuItem = new javax.swing.JMenuItem();
		deleteMenuItem = new javax.swing.JMenuItem();
		helpMenu = new javax.swing.JMenu();
		contentsMenuItem = new javax.swing.JMenuItem();
		aboutMenuItem = new javax.swing.JMenuItem();

		jLabel1.setText("jLabel1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jPanel1.setLayout(new java.awt.GridLayout(3, 0));

		result.setText("Status: idle");

		jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jPanel2.setLayout(new java.awt.GridLayout(3, 3));

		jLabel2.setText("Length:");
		jPanel2.add(jLabel2);

		slider.setMaximum(10);
		slider.setValue(3);
		slider.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				sliderChanged(evt);
			}
		});
		jPanel2.add(slider);

		jLabel4.setText("jLabel4");
		jPanel2.add(jLabel4);

		jLabel3.setText("Randomization passes:");
		jPanel2.add(jLabel3);

		rslider.setValue(20);
		rslider.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				changeRandomization(evt);
			}
		});
		jPanel2.add(rslider);

		jLabel5.setText("jLabel5");
		jPanel2.add(jLabel5);

		jLabel6.setText("Generated is solvable:");
		jPanel2.add(jLabel6);

		solvable.setSelected(true);
		solvable.setText("force solvable");
		jPanel2.add(solvable);

		jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		randomize.setText("Randomize");
		randomize.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				randomize(evt);
			}
		});

		begin.setText("<<");
		begin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				begin(evt);
			}
		});

		back.setText("<");
		back.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				before(evt);
			}
		});

		forward.setText(">");
		forward.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				next(evt);
			}
		});

		run.setText("Run");
		run.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				run(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				begin)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				back)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				forward)
																		.addContainerGap())
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				randomize,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				121,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				run,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				273,
																				Short.MAX_VALUE)
																		.addGap(
																				12,
																				12,
																				12)))));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(randomize)
														.addComponent(run))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(forward)
														.addComponent(back)
														.addComponent(begin))
										.addContainerGap(26, Short.MAX_VALUE)));

		fileMenu.setText("File");

		openMenuItem.setText("Open");
		fileMenu.add(openMenuItem);

		saveMenuItem.setText("Save");
		fileMenu.add(saveMenuItem);

		saveAsMenuItem.setText("Save As ...");
		fileMenu.add(saveAsMenuItem);

		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		editMenu.setText("Edit");

		cutMenuItem.setText("Cut");
		editMenu.add(cutMenuItem);

		copyMenuItem.setText("Copy");
		editMenu.add(copyMenuItem);

		pasteMenuItem.setText("Paste");
		editMenu.add(pasteMenuItem);

		deleteMenuItem.setText("Delete");
		editMenu.add(deleteMenuItem);

		menuBar.add(editMenu);

		helpMenu.setText("Help");

		contentsMenuItem.setText("Contents");
		helpMenu.add(contentsMenuItem);

		aboutMenuItem.setText("About");
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				12,
																				12,
																				12)
																		.addComponent(
																				result,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				769,
																				Short.MAX_VALUE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jPanel3,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jPanel2,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								440,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jPanel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				335,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				204,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jPanel3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jPanel1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												result,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												25,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitMenuItemActionPerformed
		System.exit(0);
	}// GEN-LAST:event_exitMenuItemActionPerformed

	private void updatePanel(int size) {
		jPanel1.removeAll();
		field = new JLabel[size][size];
		jPanel1.setLayout(new java.awt.GridLayout(size, 0));
		int n = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				JLabel newLabel = new javax.swing.JLabel();
				field[i][j] = newLabel;
				jPanel1.add(newLabel);
				n++;
			}
		}
		jPanel1.updateUI();
	}

	private void updateModel(int size) {
		taquin = new Taquin(size, random, solvable.isSelected());
	}

	private void updateValues(int[][] model) {
		for (int i = 0; i < model.length; i++) {
			for (int j = 0; j < model.length; j++) {
				field[i][j]
						.setText("<html><h1>" + model[j][i] + "</h1></html>");

				field[i][j].setBackground(getBackgroundColor(model,
						model[j][i], j, i));
				field[i][j].setOpaque(true);

			}
		}
	}

	private Color getBackgroundColor(int[][] model, int value, int x, int y) {
		Taquin ntaquin = new Taquin(model);
		Taquin.generateFinalState(model.length);
		int distance = ntaquin.getDistance(value, x, y);
		if (distance == 0)
			return Color.GREEN;
		else {
			Color color = Color.RED;
			for (int i = 0; i < distance; i++)
				color = color.darker();
			return color;
		}
	}

	@Override
	public void update(Observable arg0, final Object arg1) {
		result.setText((String) arg1);
		status = (String) arg1;
	}

	private void randomize(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_randomize
		if (worker != null) {
			worker.cancel(false);
			worker = null;
		}
		updateModel(field.length);
		updateValues((int[][]) taquin.getState());
		result.setText("randomized");
	}// GEN-LAST:event_randomize

	private void changeRandomization(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_changeRandomization
		random = rslider.getValue();
		jLabel5.setText(random + "");
		result.setText("idle");
	}// GEN-LAST:event_changeRandomization

	private void sliderChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_sliderChanged
		int size = slider.getValue();
		jLabel4.setText(size + "");
		updatePanel(size);
		updateModel(size);
		updateValues((int[][]) Taquin.finalState.getState());
		result.setText("idle");
	}// GEN-LAST:event_sliderChanged

	private void begin(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_begin
		current = 0;
		updateValues((int[][]) solutionList.get(current).getGameState()
				.getState());
		result.setText("depth: " + current);
		back.setEnabled(false);
		forward.setEnabled(true);
	}// GEN-LAST:event_begin

	private void before(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_before
		if (current != 0) {
			current--;
			updateValues((int[][]) solutionList.get(current).getGameState()
					.getState());
			result.setText("depth: " + current);
		}
		if (current == 0) {
			back.setEnabled(false);
		}
		if (current < solutionList.size() - 1) {
			forward.setEnabled(true);
		}
	}// GEN-LAST:event_before

	private void next(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_next
		if (current < solutionList.size()) {
			current++;
			updateValues((int[][]) solutionList.get(current).getGameState()
					.getState());
			result.setText("depth: " + current);
		}

		if (current == 1) {
			back.setEnabled(true);
		}
		if (current == solutionList.size() - 1) {
			forward.setEnabled(false);
		}
	}// GEN-LAST:event_next

	private void last() {
		current = solutionList.size() - 1;
		forward.setEnabled(false);
		updateValues((int[][]) solutionList.get(current).getGameState()
				.getState());
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TaquinGUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JButton back;
	private javax.swing.JButton begin;
	private javax.swing.JMenuItem contentsMenuItem;
	private javax.swing.JMenuItem copyMenuItem;
	private javax.swing.JMenuItem cutMenuItem;
	private javax.swing.JMenuItem deleteMenuItem;
	private javax.swing.JMenu editMenu;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JButton forward;
	private javax.swing.JMenu helpMenu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem openMenuItem;
	private javax.swing.JMenuItem pasteMenuItem;
	private javax.swing.JButton randomize;
	private javax.swing.JLabel result;
	private javax.swing.JSlider rslider;
	private javax.swing.JButton run;
	private javax.swing.JMenuItem saveAsMenuItem;
	private javax.swing.JMenuItem saveMenuItem;
	private javax.swing.JSlider slider;
	private javax.swing.JCheckBox solvable;
	// End of variables declaration//GEN-END:variables

}
