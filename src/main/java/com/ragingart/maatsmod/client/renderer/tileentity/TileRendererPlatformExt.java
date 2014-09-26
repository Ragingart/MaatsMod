package com.ragingart.maatsmod.client.renderer.tileentity;

import com.ragingart.maatsmod.client.renderer.model.ModelPlatformExt;
import com.ragingart.maatsmod.ref.Models;
import com.ragingart.maatsmod.tileentity.TileEntityPlatformExt;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by MaaT on 26.09.2014.
 */
public class TileRendererPlatformExt extends TileEntitySpecialRenderer {

    public ModelPlatformExt model= new ModelPlatformExt();


    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        if(tileEntity instanceof TileEntityPlatformExt) {
            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.5, y + 1, z + 0.5);
            GL11.glRotatef(180, -1.0F, 0.0F, 0.0F);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            this.bindTexture(Models.PlatformExt);
            model.render(0.0625F,((TileEntityPlatformExt) tileEntity).getAnimationTimer());
            GL11.glPopMatrix();
        }
    }
}
