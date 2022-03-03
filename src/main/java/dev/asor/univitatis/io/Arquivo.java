package dev.asor.univitatis.io;

/**
 * Classe importada de outro projeto! 
 */

/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Vinicius
 */
public class Arquivo
{
	private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String nomeArquivo;
    private char status;
    
    public Arquivo( String nomeArquivo )
    {
        this.nomeArquivo = nomeArquivo;
        status = 'C'; // Closed, Read, Write
    }
    
    public boolean abrirLeitura()
    {
        boolean sucesso = true;
        FileReader fileReader = null;
        
        if (status != 'C' )
        {
            System.err.println( "-- Arquivo \"" + nomeArquivo + "\" já está aberto!" );
            sucesso = false;
        }
        else
        {
            try
            {
                fileReader = new FileReader(nomeArquivo);
            }
            catch (FileNotFoundException e)
            {
                System.err.println( "-- Arquivo \"" + nomeArquivo + "\" não encontrado!" );
                sucesso = false;
                e.printStackTrace();
            }
            if (sucesso)
            {
                status = 'R';
                bufferedReader = new BufferedReader(fileReader);
            }
        }
        
        return (sucesso);
    }
    
    public boolean abrirEscrita()
    {
        boolean sucesso = true;
        FileWriter fileWriter = null;
        
        if (status != 'C' )
        {
            System.err.println( "-- Arquivo \"" + nomeArquivo + "\" já está aberto!" );
            sucesso = false;
        }
        else
        {
            try
            {
                fileWriter = new FileWriter(nomeArquivo);
            }
            catch (IOException e)
            {
                System.err.println( "-- Erro de escrita no arquivo \"" + nomeArquivo +"\"" );
                sucesso = false;
                e.printStackTrace();
            }
            if (sucesso)
            {
                status = 'W';
                bufferedWriter = new BufferedWriter(fileWriter);
            }
        }
        
        return (sucesso);
    }
    
    public String lerLinha()
    {
        String linha = null;
        if (status == 'R')
        {
            try
            {
                linha = bufferedReader.readLine();
            }
            catch (IOException e)
            {
                System.err.println( "-- Erro de leitura no arquivo \"" + nomeArquivo + "\"" );
                e.printStackTrace();
            }
        }
        else
        {
            System.err.println( "-- Arquivo \"" + nomeArquivo + "\" n�o est� pronto para leitura" );
        }
        return (linha);
    }
    
    public void escreverLinha( String linha )
    {
        if (status == 'W')
        {
            try
            {
                bufferedWriter.write(linha + "\n");
            }
            catch (IOException e)
            {
                System.err.println( "Erro de escrita no arquivo \"" + nomeArquivo + "\"" );
                //e.printStackTrace();
            }
        }
        else
        {
            System.err.println( "-- Arquivo \"" + nomeArquivo + "\" n�o est� pronto para escrita" );
        }
    }
    
    public void fecharArquivo()
    {
        if (status == 'R') // estava aberto para leitura
        {
            try
            {
                bufferedReader.close();
                status = 'C';
            }
            catch(IOException e)
            {
                System.err.println( "Erro ao fechar o arquivo \"" + nomeArquivo + "\"" );
                //e.printStackTrace();
            }
        }
        if (status == 'W') // estava aberto para grava��o
        {
            try
            {
                bufferedWriter.close();
                status = 'C';
            }
            catch(IOException e)
            {
                System.err.println( "Erro ao fechar o arquivo \"" + nomeArquivo + "\"" );
                e.printStackTrace();
            }
        }
    }
}
