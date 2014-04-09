package com.aspose.words.android.docxtopdf;

import java.io.File;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import com.aspose.words.Document;
import com.aspose.words.android.docxtopdf.R;

public class MainActivity extends Activity {

	 public void GenerateDocument() throws Exception {

		 // This is the path to the SD card.
	     String dataDir = Environment.getExternalStorageDirectory().getPath() + File.separator;

	     Document doc = new Document(dataDir + "Document Out.docx");
	     doc.save(dataDir + "Document_Out.pdf");

	 }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView tx = (TextView) findViewById(R.id.textBox);

		try {
			GenerateDocument();
			tx.setText("Docx to PDF conversion completed successfully, please check the root of your SD card");
		} catch (Exception e) {
			tx.setText("Error during document processing: " + e.getMessage());
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
