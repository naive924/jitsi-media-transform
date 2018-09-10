/*
 * Copyright @ 2018 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.nlj.transform.node.outgoing

import org.jitsi.nlj.PacketInfo
import org.jitsi.nlj.transform.node.Node
import org.jitsi.rtp.DtlsProtocolPacket
import org.jitsi.rtp.Packet
import java.nio.ByteBuffer

class DtlsSenderNode : Node("DTLS Sender") {
    override fun doProcessPackets(p: List<PacketInfo>) {
//        println("BRIAN: dtls sender module invoking next")
        next(p)
    }

    //TODO: change thread contexts here?
    fun send(buf: ByteArray, off: Int, length: Int) {
//        println("BRIAN: dtls sender module sending packets")
        processPackets(listOf(PacketInfo(DtlsProtocolPacket(ByteBuffer.wrap(buf, off, length)))))
    }
}