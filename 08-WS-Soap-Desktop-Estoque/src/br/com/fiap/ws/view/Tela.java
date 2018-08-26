package br.com.fiap.ws.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.ws.repository.NotaRepository;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtAm;
	private Text txtNAC;
	private Label lblNotaNecessriaDa;
	private Text txtNotaDaPs;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(219, 161);
		shell.setText("SWT Application");

		txtAm = new Text(shell, SWT.BORDER);
		txtAm.setBounds(109, 13, 78, 21);

		Label lblAM = new Label(shell, SWT.NONE);
		lblAM.setBounds(10, 16, 93, 15);
		lblAM.setText("Nota da sua AM");

		Label lblNAC = new Label(shell, SWT.NONE);
		lblNAC.setText("Nota da sua NAC");
		lblNAC.setBounds(10, 42, 93, 15);

		txtNAC = new Text(shell, SWT.BORDER);
		txtNAC.setBounds(109, 40, 78, 21);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					float am = Float.parseFloat(txtAm.getText());
					float nac = Float.parseFloat(txtNAC.getText());
					NotaRepository rep = new NotaRepository();
					float ps = rep.calularPS(am, nac);
					txtNotaDaPs.setText(String.valueOf(ps));
				} catch (AxisFault e1) {
					e1.printStackTrace();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(10, 82, 88, 21);
		btnNewButton.setText("Calcular");

		lblNotaNecessriaDa = new Label(shell, SWT.NONE);
		lblNotaNecessriaDa.setBounds(10, 142, 93, 15);

		txtNotaDaPs = new Text(shell, SWT.BORDER);
		txtNotaDaPs.setBounds(109, 82, 78, 21);

	}
}
