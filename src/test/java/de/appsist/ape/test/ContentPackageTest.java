package de.appsist.ape.test;

import java.util.Date;

import de.appsist.ape.content.ContentDescriptor;
import de.appsist.ape.content.Hint;
import de.appsist.ape.content.Warning;
import de.appsist.ape.utils.ContentSerializer;

public class ContentPackageTest {
	
	public static void main(String[] args) throws Exception {
		ContentDescriptor descriptor = new ContentDescriptor("myId", "de_DE");
		descriptor.setInfo("Lorem ipsum.");
		descriptor.setTitle("My title");
		descriptor.setLastUpdate(new Date());
		descriptor.setMedia("image/jpeg", "images/foo.jpg");
		descriptor.setRoutineTask(true);
		descriptor.setVersion("1.2");
		descriptor.addHint(new Hint("My nice hint for you."));
		descriptor.addWarning(new Warning("Beware!", "images/alert.png"));
		
		String serializedDescriptor = ContentSerializer.writeAsJSON(descriptor);
		
		System.out.print(serializedDescriptor);
		
		descriptor = ContentSerializer.readFromJSON(serializedDescriptor);
		
		System.out.println(ContentSerializer.writeAsJSON(descriptor));
	}

}
