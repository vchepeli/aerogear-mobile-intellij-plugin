package org.aerogear.plugin.intellij.mobile.services.sdkconfig;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import java.io.File;

public class WriteToFileRunnable implements Runnable {

    private Project project;
    private String path;
    private CharSequence cs;


    public WriteToFileRunnable(Project project, String path, CharSequence cs) {
        this.project = project;
        this.path = path;
        this.cs = cs;
    }

    @Override
    public void run() {
        File configFile = new File(this.path);
        VirtualFile vConfig = LocalFileSystem.getInstance().findFileByIoFile(configFile);
        PsiFile psiConfig = PsiManager.getInstance(this.project).findFile(vConfig);
        Document d =  PsiDocumentManager.getInstance(this.project).getDocument(psiConfig);
        d.setText(this.cs);
    }
}
