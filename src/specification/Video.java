/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specification;

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
    
    /*public long duration() {
        IContainer icontainer = IContainer.make();
        int res = icontainer.open(this.getPath(), IContainer.Type.READ, null);
        if(res>=0)
        {
            return icontainer.getDuration();
        }
        else
        {
            return -1;
        }
    }*/
}