package core.jbehave;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.XML;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;


public class JbehaveRunner extends JUnitStories {
	 
	@Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
          .useStoryLoader(new LoadFromClasspath(this.getClass()))
          .useStoryReporterBuilder(new StoryReporterBuilder()
            .withCodeLocation(codeLocationFromClass(this.getClass()))
            .withFormats(CONSOLE, HTML, XML));
    }
 
    @Override
    public InjectableStepsFactory stepsFactory() {
    	
    	List<Object> results = new ArrayList<Object>();

    	File[] files = new File("./src/main/java/core/steps").listFiles(); 
    	Object obj=null;
    	for (File file : files) {
    	    if (file.isFile()) {
    	    	String classNameDef =  "core.steps." + file.getName().replace(".java", "");
    	    	try {
    	    		Class c = Class.forName(classNameDef); 
    				obj = c.newInstance();
    			} catch (InstantiationException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (IllegalAccessException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (ClassNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} 
    	        results.add(obj);
    	    }
    	} 
     	
        return new InstanceStepsFactory(configuration(), results);
    }
 
   
    protected List<String> storyPaths() {
    	StoryFinder finder = new StoryFinder();
        return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/*.story"), Arrays.asList(""));
    	
    }
     
 
}
