/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5.commands;

import com.mycompany.laboratorul5.domain.Catalog;
import com.mycompany.laboratorul5.exceptions.InvalidCommandException;
import freemarker.core.ParseException;
import java.util.List;
import freemarker.template.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Radu
 */
public class ReportCommand extends Command {

    private final String SYNTAX = "report <catalog -> name>";

    public ReportCommand(Shell shell) {
        super("report", 1);
        this.shell = shell;
    }

    @Override
    public void execute(List<String> arguments) {
        if (arguments.size() != this.numberOfArguments) {
            throw new InvalidCommandException(SYNTAX);
        }

        String name = arguments.get(0);
        Catalog catalog = this.shell.findCatalogByName(name);
        if (catalog == null) {
            System.out.println("The catalog doesn't exist!");
        } else {

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            try {
                cfg.setDirectoryForTemplateLoading(new File("e:/Templates"));
            } catch (IOException ex) {
                System.err.println(ex);
            }

            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);

            try {
                Template temp = cfg.getTemplate("test.ftlh");
            } catch (MalformedTemplateNameException ex) {
                System.err.println(ex);
            } catch (ParseException ex) {
                System.err.println(ex);
            } catch (IOException ex) {
                System.err.println(ex);
            }

        }
    }
}
