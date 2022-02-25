package org.java17recipes.chapter08.recipe08_01;


import java.awt.*;
import java.io.Serializable;

public class ProgramSettings implements Serializable {
   private Point locationOnScreen;
   private Dimension frameSize;
   private Color defaultFontColor;
   private String title;

   // Empty constructor


   public ProgramSettings() {

   }

   public ProgramSettings(Point locationOnScreen, Dimension frameSize, Color defaultFontColor, String title) {
       this.locationOnScreen = locationOnScreen;
       this.frameSize = frameSize;
       this.defaultFontColor = defaultFontColor;
       this.title = title;
   }

   public Point getLocationOnScreen() {
       return locationOnScreen;
   }

   public void setLocationOnScreen(Point locationOnScreen) {
       this.locationOnScreen = locationOnScreen;
   }

   public Dimension getFrameSize() {
       return frameSize;
   }

   public void setFrameSize(Dimension frameSize) {
       this.frameSize = frameSize;
   }

   public Color getDefaultFontColor() {
       return defaultFontColor;
   }

   public void setDefaultFontColor(Color defaultFontColor) {
       this.defaultFontColor = defaultFontColor;
   }

   public String getTitle() {
       return title;
   }

   public void setTitle(String title) {
       this.title = title;
   }

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;

       ProgramSettings that = (ProgramSettings) o;

       if (defaultFontColor != null ? !defaultFontColor.equals(that.defaultFontColor) : that.defaultFontColor != null)
           return false;
       if (frameSize != null ? !frameSize.equals(that.frameSize) : that.frameSize != null) return false;
       if (locationOnScreen != null ? !locationOnScreen.equals(that.locationOnScreen) : that.locationOnScreen != null)
           return false;
       if (title != null ? !title.equals(that.title) : that.title != null) return false;

       return true;
   }

   @Override
   public int hashCode() {
       int result = locationOnScreen != null ? locationOnScreen.hashCode() : 0;
       result = 31 * result + (frameSize != null ? frameSize.hashCode() : 0);
       result = 31 * result + (defaultFontColor != null ? defaultFontColor.hashCode() : 0);
       result = 31 * result + (title != null ? title.hashCode() : 0);
       return result;
   }
}

