/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification.enties;

//import com.xuggle.xuggler.IContainer;
import entites.FileExtended;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author guezel
 */
public class Video extends FileExtended {

    private long duration;
    
    /**
     *
     * @param f
     * @throws IOException
     */
    public Video(File f) throws IOException {
        super(f);
        //this.duration = duration();
        
    }

    /**
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }
}