package com.hotstar.player.custom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BytesManager {

    public static byte[] getBytes(InputStream inputStream)
    {
        byte[] bytes= null;

        try
        {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            byte data[] = new byte[1024];
            int count;

            while ((count = inputStream.read(data)) != -1)
            {
                bos.write(data, 0, count);
            }

            bos.flush();
            bos.close();
            inputStream.close();

            bytes = bos.toByteArray();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bytes;
    }
}