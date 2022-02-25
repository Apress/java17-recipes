package org.java17recipes.chapter11.recipe11_02;


import java.text.DateFormat;
import java.util.Locale;
import java.util.Locale.Builder;
import java.text.NumberFormat;
import java.util.Date;

public class Recipe11_2 {
   private static final long SAMPLE_NUMBER = 123456789L;
   private static final Date NOW = new Date();
   
   public static void main(String[] args) {
       Recipe11_2 app = new Recipe11_2();
       
       
       app.run();
   }

   
   public void run() {
       createFromBuilder();
       createFromLanguageTag();
       createFromConstructor();
       createFromStatics();
   }
   
   public void createFromBuilder() {
       System.out.printf("Creating from Builder...\n\n");
       String[][] langRegions = {{"fr", "FR"}, {"ja", "JP"}, {"en", "US"}};        
       Builder builder = new Builder();
       Locale l = null;
       for (String[] lr: langRegions) {
           builder.clear();
           builder.setLanguage(lr[0]).setRegion(lr[1]);
           l = builder.build();
           displayLocalizedData(l, SAMPLE_NUMBER, NOW);            
       }        
   }
   
   public void createFromLanguageTag() {
       System.out.printf("Creating from BCP 47 language tags...\n\n");
       String[] bcp47LangTags= {"fr-FR", "ja-JP", "en-US"};        
       Locale l = null;
       for (String langTag: bcp47LangTags) {
           l = Locale.forLanguageTag(langTag);
           displayLocalizedData(l, SAMPLE_NUMBER, NOW);        
       }
       
   }
   
   public void createFromConstructor() {
       System.out.printf("Creating from Locale constructor...\n\n");
       String[][] langRegions = {{"fr", "FR"}, {"ja", "JP"}, {"en", "US"}};        
       Locale l = null;
       for (String[] args: langRegions) {
           // arg[0] is ISO 639 language code, arg[1] is an ISO 3166 region
           l = new Locale(args[0], args[1]);
           displayLocalizedData(l, SAMPLE_NUMBER, NOW);
       }       
       
   }

   public void createFromStatics() {
       System.out.printf("Creating from Locale static constants...\n\n");
       Locale[] locales = new Locale[]{Locale.FRANCE, Locale.JAPAN, Locale.US};        
       for (Locale l: locales) {
           displayLocalizedData(l, SAMPLE_NUMBER, NOW);
       }       
       
      
   }
   
   private void displayLocalizedData(Locale l, long number, Date date) {
       NumberFormat nf = NumberFormat.getInstance(l);
       DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, l);
       System.out.printf("Locale: %s\nNumber: %s\nDate: %s\n\n",
           l.getDisplayName(),
           nf.format(number),
           df.format(date));          
   }
}

