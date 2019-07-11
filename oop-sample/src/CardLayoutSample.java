import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CardLayoutの使い方のサンプル
 * @author mumvall
 *
 */
public class CardLayoutSample extends JFrame implements ActionListener {
	
	/**  */
	JPanel panel;
	CardLayout layout;
	
	/**
	 * mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		CardLayoutSample frame = new CardLayoutSample();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(10, 10, 300, 200);
	    frame.setTitle("タイトル");
	    frame.setVisible(true);
		
	}
	
	/**
	 * コンストラクタ
	 */
	CardLayoutSample() {
	    /* View1 */
	    JPanel card1 = new JPanel();
	    card1.add(new JLabel("View1"));
	    JButton goToV2Button = new JButton("Go To View2");
	    goToV2Button.addActionListener(this);
	    goToV2Button.setActionCommand("View2");
	    card1.add(goToV2Button);
	    
	    /* View2 */
	    JPanel card2 = new JPanel();
	    card2.add(new JLabel("View2"));
	    JButton goToV1Button = new JButton("Go To View1");
	    goToV1Button.addActionListener(this);
	    goToV1Button.setActionCommand("View1");
	    card2.add(goToV1Button);
	    
	    /* CardLayout準備 */
	    this.panel = new JPanel();
	    this.layout = new CardLayout();//CardLayoutの作成
	    this.panel.setLayout(this.layout);
	    
	    /* panelにViewを追加 */
	    this.panel.add(card1, "View1");
	    this.panel.add(card2, "View2");
	    
	    // パネルの生成
	    JPanel btnPanel = new JPanel();
	    btnPanel.add(goToV2Button);
	    btnPanel.add(goToV1Button);
	    
	    getContentPane().add(this.panel, BorderLayout.CENTER);
	    getContentPane().add(btnPanel, BorderLayout.PAGE_END);
	}

	/**
	 * actionが発生したときのイベントハンドラ
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 設定したコマンド文字列
	    String cmd = e.getActionCommand();
	    // パネルの切り替え
	    layout.show(this.panel,cmd);
	}

}
