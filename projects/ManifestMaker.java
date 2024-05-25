import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
 
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
 
public class ManifestMaker {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		ManifestMaker mm = new ManifestMaker(args);
	}
 
	public ManifestMaker(String[] args) {
		File jarfile = null;
		String mainclass = "";
 
		if (args.length > 0) {
			jarfile = new File(args[0]);
			if (!jarfile.exists()) {
				JOptionPane.showMessageDialog(
					null,
					"File not found: " + jarfile.getAbsoluteFile(),
					"Error",
					JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}
		if (args.length > 1) {
			mainclass = args[1];
		}
 
		if (jarfile == null) {
			JFileChooser fc = new JFileChooser();
			fc.setMultiSelectionEnabled(false);
			fc.setAcceptAllFileFilterUsed(false);
			fc.setFileSelectionMode(fc.FILES_ONLY);
			//fc.setCurrentDirectory(new File("c:\\java stuff\\"));
			fc.setFileFilter(new FileFilter() {
				public boolean accept(File file) {
					String f = file.getName();
					return f.endsWith(".jar") || file.isDirectory();
				}
				public String getDescription() {
					return "*.jar";
				}
			});
			fc.setDialogTitle("Select the Jar File to which you want to add the Manifest");
			fc.showOpenDialog(null);
			jarfile = fc.getSelectedFile();
 
			if (jarfile == null) {
				System.exit(0);
			}
		}
		if (mainclass.equals("")) {
			try {
				JarInputStream in = new JarInputStream(new FileInputStream(jarfile));
				JarEntry ent;
				Vector classes = new Vector();
 
				URL[] loadingURLs = { jarfile.toURL()};
				ClassLoader cl = new URLClassLoader(loadingURLs);
 
				while ((ent = in.getNextJarEntry()) != null) {
					if (ent.getName().toLowerCase().endsWith(".class")) {
						StringTokenizer tok = new StringTokenizer(ent.getName(), "/");
 
						String fullpropername = "";
 
						while (tok.hasMoreTokens())
							fullpropername += tok.nextToken() + ".";
 
						fullpropername = fullpropername.substring(0, fullpropername.length() - 7);
 
						try {
							Method[] m = cl.loadClass(fullpropername).getMethods();
 
							for (int mi = 0; mi < m.length; mi++) {
								if (m[mi].getName().equals("main")) {
									classes.add(ent.getName().substring(0, ent.getName().length() - 6));
								}
							}
						} catch (Exception e) {
						}
					}
					in.closeEntry();
				}
 
				in.close();
 
				if (classes.size() > 0) {
 
					JComboBox combo = new JComboBox();
 
					for (int i = 0; i < classes.size(); i++) {
						combo.addItem("" + classes.get(i));
					}
 
					if (JOptionPane
						.showOptionDialog(
							null,
							combo,
							"Select the Main Class then Click Yes to Contiue",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							null,
							null)
						== 0) {
						mainclass = "" + combo.getSelectedItem();
					}
				}
			} catch (Exception e) {
			}
 
			if (mainclass == null || mainclass.equals("")) {
				mainclass =
					JOptionPane.showInputDialog(
						null,
						"Enter the main class in the format of <package path>/<mainclass (no .class)>, eg. manifest_maker/ManifestMaker",
						"Enter Info",
						JOptionPane.QUESTION_MESSAGE);
				if (mainclass == null) {
					System.exit(0);
				}
			}
		}
 
		try {
			File tempfile = new File(File.createTempFile("manifestmaker",null).getAbsolutePath());
 
			JarInputStream in = new JarInputStream(new FileInputStream(jarfile));
			JarOutputStream out = new JarOutputStream(new FileOutputStream(tempfile));
 
			JarEntry ent;
			String manifeststr = "Manifest-Version: 1.0\nMain-Class: " + mainclass + "\n";
 
			while ((ent = in.getNextJarEntry()) != null) {
				if (!ent.getName().toUpperCase().equals("META-INF/MANIFEST.MF")
					&& !ent.getName().toUpperCase().equals("META-INF\\MANIFEST.MF")) {
					out.putNextEntry(new ZipEntry(ent.getName()));
					out.setLevel(9);
 
					int l = 0;
					byte[] b = new byte[1];
					while ((l = in.read(b, 0, 1)) > 0)
						out.write(b, 0, 1);
					out.closeEntry();
				}
			}
 
			byte[] b = new byte[manifeststr.length()];
 
			for (int i = 0; i < manifeststr.length(); i++) {
				b[i] = (byte) manifeststr.charAt(i);
			}
			out.putNextEntry(new ZipEntry("META-INF/MANIFEST.MF"));
			out.setLevel(9);
			out.write(b, 0, manifeststr.length());
			out.closeEntry();
 
			out.finish();
			out.close();
			in.close();
 
			FileInputStream fis = new FileInputStream(tempfile);
			FileOutputStream fos = new FileOutputStream(jarfile);
 
			int fb;
 
			while ((fb = fis.read()) != -1)
				fos.write(fb);
 
			fis.close();
			fos.close();
 
			tempfile.delete();
			JOptionPane.showMessageDialog(
				null,
				"Done! " + mainclass + ".class has been made the default executable class.",
				"Done!",
				JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		System.exit(0);
	}
}
