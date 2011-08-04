import java.util.*;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.odfdom.type.Color;
import org.odftoolkit.simple.style.Font;
import org.odftoolkit.simple.style.StyleTypeDefinitions.FontStyle;
import java.util.zip.*;
import java.io.*;

public class vandal 
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		vandal me = new vandal();
		
		System.out.print("Enter the source ZIP file : ");
		String location = br.readLine();
		me.Invade(location,location); // Source and destination set to same, gives the modified zip file!
	}
	
	TextDocument InputDocument,OutputDocument;
	Color Pink;
	Font BigNoticeFont,Pink32PtComicSansFont;
	Paragraph BigNotice;
	
	public vandal()
	{
		Pink = new Color(255, 192, 203);
		BigNoticeFont = new Font("Comic Sans MS", FontStyle.REGULAR, 72); 
		Pink32PtComicSansFont = new Font("Comic Sans MS", FontStyle.REGULAR, 32, Pink); 
	}
	
	// Unzips, formats the odt files, and zips it back! 
	public void  Invade(String SourceZipFile, String DestinationZipFile)
	{
		try
		{
			ZipFile zFile = new ZipFile(SourceZipFile); // Input zip file
			
			File OutputFiles[] = new File[zFile.size()]; // The list of files to be added to the zip ie., the invaded odt files
			int i=0; // Index variable for OutputFiles[]
			
			File TempDir = new File("Temp"); // Temporary directory to which the input zip is unzipped
			unzipFileIntoDirectory(zFile, TempDir); // Unzips the zip file 'zFile' in to directory 'dir'
			
			
			// Iterates throgh each file in the "Temp" directory
			for (File child : TempDir.listFiles()) 
			{
				if (".".equals(child.getName()) || "..".equals(child.getName()) )
					continue;  // Ignore the self and parent aliases.
				
				System.out.print("Processing '"+child.getName()+ "'...........");
				ConvertFile("Temp\\" + child.getName(),"Temp\\"+child.getName()); // Opens and formats the odt files from Temp directory and writes it back
				System.out.println("[OK]");
				OutputFiles[i++]= new File("Temp\\"+child.getName()); // Adds the invaded file to output file list
			}

			zipFile(OutputFiles, new File(DestinationZipFile)); // Makes a zip file with files in OutputFiles[]

			
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
	
	// Opens the Source ODT file, formats it and save it as Destination ODT file
	public void ConvertFile(String Source, String Destination)
	{
		try 
		{
			InputDocument = (TextDocument)TextDocument.loadDocument(Source); // Loads the input document
			OutputDocument = TextDocument.newTextDocument(); // Creates and output document

			String paraTxt; // A temporary variable to store the text from each paragaraph in the odt file
			Paragraph TempParagraph; // A temporary Paragraph object to iterate through the paragraphs in the odt file 
			
			BigNotice = OutputDocument.addParagraph("All your base are belong to us"); // Creates "All your base are belong to us" as the first paragraph in the ouput odt file
			BigNotice.getStyleHandler().getTextPropertiesForWrite().setFont(BigNoticeFont); // Sets the first paragraph style to 72pt Comic Sans
			
			Iterator<Paragraph> paras = InputDocument.getParagraphIterator(); // Iterator to iterate through each paragraph in input document
			while (paras.hasNext()) 
			{
				Paragraph para = paras.next(); // Get paragraph as Paragraph object
				paraTxt = para.getTextContent(); // Get paragraph text from input document
				TempParagraph = OutputDocument.addParagraph(paraTxt); // Adds the text to Ouput document 
				TempParagraph.getStyleHandler().getTextPropertiesForWrite().setFont(Pink32PtComicSansFont); // Sets the style to 32pt Comic Sans in pink
			}			
			
			InputDocument.close(); // Closes the input document
			OutputDocument.save(Destination); // Writes the output document in to Destination file
			OutputDocument.close(); // Closes the output document
		} 
		catch (Exception e) 
		{
			System.err.println("ERROR: unable to create output file.");
		}
	}
	
	// A general code for Unzipping file into directory.
	public static void unzipFileIntoDirectory(ZipFile zipFile, File jiniHomeParentDir) {
		Enumeration files = zipFile.entries();
		File f = null;
		FileOutputStream fos = null;
		
		while (files.hasMoreElements()) {
			try {
				ZipEntry entry = (ZipEntry) files.nextElement();
				InputStream eis = zipFile.getInputStream(entry);
				byte[] buffer = new byte[1024];
				int bytesRead = 0;

				f = new File(jiniHomeParentDir.getAbsolutePath() + File.separator + entry.getName());
				
				if (entry.isDirectory()) {
					f.mkdirs();
					continue;
				} else {
					f.getParentFile().mkdirs();
					f.createNewFile();
				}
				
				fos = new FileOutputStream(f);

				while ((bytesRead = eis.read(buffer)) != -1) {
					fos.write(buffer, 0, bytesRead);
				}
				eis.close();
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						System.err.println("Error while closing fos");
					}
				}
			}
		}
	}
	
	
	// A general code for ziping a list of files into a zip file.
	public static void zipFile(final File[] files, final File targetZipFile) throws IOException {
		try {
			FileOutputStream   fos = new FileOutputStream(targetZipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			byte[] buffer = new byte[128];
			for (int i = 0; i < files.length; i++) {
				File currentFile = files[i];
				if (!currentFile.isDirectory()) {
					ZipEntry entry = new ZipEntry(currentFile.getName());
					FileInputStream fis = new FileInputStream(currentFile);
					zos.putNextEntry(entry);
					int read = 0;
					while ((read = fis.read(buffer)) != -1) {
						zos.write(buffer, 0, read);
					}
					zos.closeEntry();
					fis.close();
				}
			}
			zos.close();
			fos.close();
			
			System.out.println("Modified Zip file created : "+targetZipFile.getAbsolutePath() );
		} catch (FileNotFoundException e) {
			System.out.println("File not found : " + e);
		}

	}
	
	
	
	

}