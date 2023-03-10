package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Star extends Object2d{
    double rad;
    float x;
    float y;
    public Star(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerpoint, double radius) {
        super(shaderModuleDataList, vertices, color);
        this.createStar(centerpoint, radius);
        setupVAOVBO();
    }

    public void createStar(Vector3f centerpoint, double radius){
        for(double i = 36.0f; i < 756; i += 144.0f){
            rad = Math.toRadians(i);
            x = (float)(centerpoint.x + radius*Math.cos(rad));
            y = (float)(centerpoint.y + radius*Math.sin(rad));
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }

    public void draw() {
        drawSetup();
        glLineWidth(1.0f);
        glDrawArrays(GL_LINE_LOOP, 0, vertices.size());
    }
}
