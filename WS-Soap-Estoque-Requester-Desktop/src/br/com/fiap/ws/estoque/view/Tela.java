package br.com.fiap.ws.estoque.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.ws.estoque.bo.EstoqueBOStub;
import br.com.fiap.ws.estoque.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.ws.estoque.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.ws.estoque.bo.EstoqueBOStub.ProdutoTO;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtCodigoProduto;
	private Text txtNome;

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
		shell.setSize(388, 277);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					EstoqueBOStub stub = new EstoqueBOStub();
					
					ConsultarProduto params = new ConsultarProduto();
					
					int codigo = Integer.parseInt(txtCodigoProduto.getText());
					params.setCodigo(codigo);

					ConsultarProdutoResponse resp = 
							stub.consultarProduto(params);

					ProdutoTO to = resp.get_return();
					System.out.println(to.getCodigo());
					System.out.println(to.getNome());
					System.out.println(to.getDescricao());
					System.out.println(to.getPreco());
					
				txtNome.setText(String.valueOf(to.getNome()));
					
				} catch (AxisFault e1) {
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(258, 10, 75, 25);
		btnNewButton.setText("Pesquisar");
		
		Label lblCdigoDoProduto = new Label(shell, SWT.NONE);
		lblCdigoDoProduto.setBounds(10, 15, 114, 15);
		lblCdigoDoProduto.setText("C\u00F3digo do Produto");
		
		txtCodigoProduto = new Text(shell, SWT.BORDER);
		txtCodigoProduto.setBounds(130, 10, 101, 21);
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(10, 79, 55, 15);
		lblNome.setText("Nome:");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(83, 76, 185, 21);

	}
}
