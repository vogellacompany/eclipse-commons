package testcase.de.jcup.eclipse.commons;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import de.jcup.eclipse.commons.presentation.PresentationSupport;

public class TestCaseSourceViewerConfiguration extends SourceViewerConfiguration {
	private TextAttribute defaultTextAttribute;

	public TestCaseSourceViewerConfiguration() {
		this.defaultTextAttribute = new TextAttribute(
				Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		addDefaultPresentation(reconciler);

		String id = "id1";
		RGB color = new RGB(255, 0, 0);
		addPresentation(reconciler, id, color, SWT.NONE);

		return reconciler;
	}
	
	@Override
	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
		// TODO Auto-generated method stub
		return super.getConfiguredDocumentPartitioning(sourceViewer);
	}

	private void addDefaultPresentation(PresentationReconciler reconciler) {
		/* FIXME implement...*/
//		ITokenScanner scanner;
//		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(scanner);
//		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
//		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
	}

	private void addPresentation(PresentationReconciler reconciler, String id, RGB rgb, int style) {
		TestCaseColorManager colorManager = getColorManager();
		TextAttribute textAttribute = new TextAttribute(colorManager.getColor(rgb),
				defaultTextAttribute.getBackground(), style);
		PresentationSupport presentation = new PresentationSupport(textAttribute);
		reconciler.setDamager(presentation, id);
		reconciler.setRepairer(presentation, id);
	}

	protected TestCaseColorManager getColorManager() {
		return TestcaseActivator.getDefault().getTestCaseColorManager();
	}

}
