package chuwxntc.wikilookup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;

import org.apache.cordova.*;

public class Wikilookup extends DroidGap {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setIntegerProperty("splashscreen", R.drawable.splash);
		super.loadUrl(Config.getStartUrl(), 3000);
		
		// Disable scrollbars 
        // super.appView.setVerticalScrollBarEnabled(false);
        super.appView.setHorizontalScrollBarEnabled(false);

		super.appView.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				return true;
			}
		});

		try {
			File dbFile = getDatabasePath("bus_sai_gon.db");
			if (!dbFile.exists()) {
				this.copy("bus_sai_gon.db", dbFile.getAbsolutePath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			File dbFile = getDatabasePath("wikilookup.db");
			if (!dbFile.exists()) {
				this.copy("wikilookup.db", dbFile.getAbsolutePath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// And our copy function:
	void copy(String file, String folder) throws IOException {
		File CheckDirectory;
		CheckDirectory = new File(folder);

		String parentPath = CheckDirectory.getParent();

		File filedir = new File(parentPath);
		if (!filedir.exists()) {
			if (!filedir.mkdirs()) {
				return;
			}
		}

		InputStream in = this.getApplicationContext().getAssets().open(file);
		File newfile = new File(folder);
		OutputStream out = new FileOutputStream(newfile);

		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0)
			out.write(buf, 0, len);
		in.close();
		out.close();
	}
}
