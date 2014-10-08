package com.ragingart.maatsmod.client.renderer.tileentity;

import com.ragingart.maatsmod.client.renderer.model.ModelFluxField;
import com.ragingart.maatsmod.ref.Models;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by MaaT on 26.09.2014.
 */
public class TileRendererPlatformExt extends TileEntitySpecialRenderer {

    public static ModelFluxField model= new ModelFluxField();


    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glScalef(-0.5F,-1,0.5F);
        this.bindTexture(Models.PlatformExt);
        GL11.glEnable(GL11.GL_BLEND);
        model.render();
        GL11.glPopMatrix();
    }
}
