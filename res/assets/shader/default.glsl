#type vertex
#version 330 core

layout(location = 0) in vec3 position;
layout(location = 1) in vec3 color;
layout(location = 2) in vec2 textureCoords;

out vec3 passColor;
out vec2 passTextureCoords;

void main() {
    gl_Position = vec4(position, 1.0);
    passColor = color;
    passTextureCoords = textureCoords;
}

#type fragement
#version 330 core

in vec3 passColor;
in vec2 passTextureCoords;

out vec4 outColor;

uniform sampler2D tex;

void main() {
    outColor = texture(tex, passTextureCoords);
}